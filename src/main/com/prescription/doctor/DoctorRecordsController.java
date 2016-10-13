package com.prescription.doctor;

import java.util.List;

import com.prescription.models.*;

import com.prescription.interceptors.DoctorAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;

@ParentPackage("mainprescription")
public class DoctorRecordsController extends ActionSupport implements DoctorAware, ModelDriven<Object>{
	private Records model = new Records();
	private List<Records> list;
	private RecordsService recordsService = new RecordsService();

	public HttpHeaders index()
	{
		list = recordsService.getAll();
		return new DefaultHttpHeaders("index").disableCaching();
	}	

	public Object getModel() {
	  return (list != null ? list : model);
	}
}