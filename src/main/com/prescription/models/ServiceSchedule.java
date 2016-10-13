package com.prescription.models;

public class ServiceSchedule {
	private String scheduleID;
	private String doctorID;
	private String patientID;
	private String dTime;
	private String dDate;  
	private String dChember;
	private String accept;

	public ServiceSchedule(){
		
	}
	
	public ServiceSchedule(String a, String b, String c, String d, String e, String f, String g){
		this.setScheduleID(a);
		this.setDoctorID(b);
		this.setPatientID(c);
		this.setdTime(d);
		this.setdDate(e);
		this.setdChember(f);
		this.setAccept(g);
	}
	
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getdTime() {
		return dTime;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}
	public String getdChember() {
		return dChember;
	}
	public void setdChember(String dChember) {
		this.dChember = dChember;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}


}
