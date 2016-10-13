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
public class DoctorAppointmentController extends ActionSupport implements DoctorAware, ModelDriven<Object>{
	private ServiceSchedule model = new ServiceSchedule();
	private List<ServiceSchedule> list;
	private ServiceSchedulesService serviceschedulesService = new ServiceSchedulesService();

	public HttpHeaders index()
	{
		list = serviceschedulesService.getAll();
		return new DefaultHttpHeaders("index").disableCaching();
	}	

	public Object getModel() {
	  return (list != null ? list : model);
	}

	public HttpHeaders accept()
	{
		return new DefaultHttpHeaders("success");
	}
}