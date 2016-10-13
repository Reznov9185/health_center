package com.prescription.models;

public class Doctor {

	private String doctorID;
	private String username;
	private String dName;
	private String dMail;
	private String dAddress;
	private String dDegrees;
	private String dSubject;
	private String dExperience;
	public Doctor(){
		
	}
	public Doctor(String a, String b, String c, String d, String e, String f, String g, String h)
	{
		this.setDoctorID(a);
		this.setUsername(b);
		this.setdName(c);
		this.setdMail(d);
		this.setdAddress(e);
		this.setdDegrees(f);
		this.setdSubject(g);
		this.setdExperience(h);	
	}
	
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdMail() {
		return dMail;
	}
	public void setdMail(String dMail) {
		this.dMail = dMail;
	}
	public String getdAddress() {
		return dAddress;
	}
	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}
	public String getdDegrees() {
		return dDegrees;
	}
	public void setdDegrees(String dDegrees) {
		this.dDegrees = dDegrees;
	}
	public String getdSubject() {
		return dSubject;
	}
	public void setdSubject(String dSubject) {
		this.dSubject = dSubject;
	}
	public String getdExperience() {
		return dExperience;
	}
	public void setdExperience(String dExperience) {
		this.dExperience = dExperience;
	}
	
	

	
	
}
