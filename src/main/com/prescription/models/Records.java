package com.prescription.models;


public class Records {
	private String recordID;
	private String doctorID;
	private String patientID;
	private String date;
	private String medications;
	private String dRemarks;
	private String pRemarks;

	public Records(){
		
	}
	
	public Records(String a, String b, String c, String d, String e, String f, String g){
		this.setRecordID(a);
		this.setDoctorID(b);
		this.setPatientID(c);
		this.setDate(d);
		this.setMedications(e);
		this.setdRemarks(f);
		this.setpRemarks(g);
	}
	public String getRecordID() {
		return recordID;
	}
	public void setRecordID(String recordID) {
		this.recordID = recordID;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMedications() {
		return medications;
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getdRemarks() {
		return dRemarks;
	}
	public void setdRemarks(String dRemarks) {
		this.dRemarks = dRemarks;
	}
	public String getpRemarks() {
		return pRemarks;
	}
	public void setpRemarks(String pRemarks) {
		this.pRemarks = pRemarks;
	}
	
	
}
