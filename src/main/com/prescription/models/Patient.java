package com.prescription.models;

public class Patient {
	private String patientID;
	private String username; 
	private String pName;
	private String pMail;
	private String pAddress;

	public Patient(){
		
	}
	
	public Patient(String a, String b, String c, String d, String e)
	{
		this.setPatientID(a);
		this.setUsername(b);
		this.setpName(c);
		this.setpMail(d);
		this.setpAddress(e);
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpMail() {
		return pMail;
	}
	public void setpMail(String pMail) {
		this.pMail = pMail;
	}
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	

}
