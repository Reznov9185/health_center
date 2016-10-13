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
public class DoctorScheduleController extends ActionSupport implements DoctorAware, ModelDriven<Object>{
	private Dschedule model = new Dschedule();
	private String id;
	private List<Dschedule> list;
	private DschedulesService dSchedulesService = new DschedulesService();

	public HttpHeaders index()
	{
		list = dSchedulesService.getAll();
		return new DefaultHttpHeaders("index").disableCaching();
	}	

	public Object getModel() {
	  return (list != null ? list : model);
	}

	public HttpHeaders show() {
	  return new DefaultHttpHeaders("show");
	}

	public String edit() {
	  return "edit";
	}

	public String editNew() {
	  model = new Dschedule();
	  return "editNew";
	}

	public String destroy() {
	  dSchedulesService.remove(id);
	  addActionMessage("Schedule removed successfully");
	  return "success";
	}

	public HttpHeaders create() {
	  dSchedulesService.save(model);
	  addActionMessage("New schedule created successfully");
	  return new DefaultHttpHeaders("success").setLocationId(model.getDoctorID());
	}

	public String update() {
	  dSchedulesService.save(model);
	  addActionMessage("Schedule updated successfully");
	  return "success";
	}

	public void setId(String id)   
    {   
        this.id = id;    
        if (Integer.parseInt(id) > 0)   
        {   
            this.model = dSchedulesService.get(id);   
        }   
    }   
    public String getId()   
    {   
        return this.id;   
    }  
}