package com.prescription.models;

public class Dschedule {
	private String doctorID;
	private String dChember;
	private String dTime;

	public Dschedule(){
		
	}
	
	public Dschedule(String a,String b,String c)
	{
		this.setDoctorID(a);
		this.setdChember(b);
		this.setdTime(c);
	}
	
	
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getdChember() {
		return dChember;
	}
	public void setdChember(String dChember) {
		this.dChember = dChember;
	}
	public String getdTime() {
		return dTime;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}


}
