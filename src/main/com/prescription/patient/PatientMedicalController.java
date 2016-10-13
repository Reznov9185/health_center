package com.prescription.patient;

import java.util.List;

import com.prescription.models.*;

import com.prescription.interceptors.PatientAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;

public class PatientMedicalController extends ActionSupport implements PatientAware, ModelDriven<Object>{
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