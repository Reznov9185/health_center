package com.prescription.models;

public class User {
	private String username;
	private String password;
	private String usertype;

	public User()
	{
		
	}

	public User(String a,String b,String c)
	{	
		this.setUsername(a);
		this.setPassword(b);
		this.setUsertype(c);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}
