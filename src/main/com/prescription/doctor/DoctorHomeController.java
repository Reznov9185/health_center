package com.prescription.doctor;

import com.prescription.interceptors.DoctorAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;

@ParentPackage("mainprescription")
public class DoctorHomeController extends ActionSupport implements DoctorAware{
	
}