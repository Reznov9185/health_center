package com.prescription.models;
//import java.lang.*;
//import java.io.*;
import java.util.*;
import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
import java.sql.*;
import java.text.*;
public class DbAccess {
	private String jdbcDriver;
	private String dbUrl;
	private String user;
	private String pass;

	
	public void setJdbcDriver(String s){
		this.jdbcDriver=s;
	}
	
	public String getJdbcDriver(){
		return this.jdbcDriver;
	}
	
	public void setDbUrl(String s){
		this.dbUrl=s;
	}
	
	public String getDbUrl(){
		return this.dbUrl;
	}
	
	public void setUser(String s){
		this.user=s;
	}
	
	public String getUser(){
		return this.user;
	}
	
	public void setPass(String s){
		this.pass=s;
	}
	
	public String getPass(){
		return this.pass;
	}

	public DbAccess()	
	{
		this.setJdbcDriver("com.mysql.jdbc.Driver");  
		this.setDbUrl("jdbc:mysql://localhost/prescription");
		this.setUser ("root");
		this.setPass ("");
	}

	public ArrayList<ArrayList<String>> executeQuery( String s)
	{
		System.out.println("INSIDE");
		ArrayList<ArrayList<String>> finalResult=new ArrayList<ArrayList<String>>();
		ArrayList<String> result=new ArrayList<String>();
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl=this.getDbUrl();
			String user= this.getUser();
			String pass= this.getPass();

			// Open a connection
			Connection conn = DriverManager.getConnection(dbUrl,user,pass);

			// Execute SQL query
			Statement stmt = conn.createStatement();
			String sql=s;

			System.out.println("HERE");
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			// Extract data from result set
			while(rs.next()){
				System.out.println("Row found");
				for (int i = 1; i <= columnCount ; i++ ) 
				{				
					String name = rsmd.getColumnName(i);
					int type=rsmd.getColumnType(i);
					switch(type)
					{
						//if column type is integer
						case 4:
							int temp0= rs.getInt(name);
							String temp1= Integer.toString(temp0);
							result.add(temp1);
							break;
						//if column type is String
						case 12:
							String temp2= rs.getString(name);
							result.add(temp2);
							break;
						//if column type is Date
						case 91:
							java.util.Date date= rs.getDate(name);
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							String a = df.format(date);
							result.add(a);
							break;
					}
					finalResult.add(result);
					result.clear();

				}

			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return finalResult;
	}
	
	public boolean updateQuery( String s)
	{
		boolean flag=false;
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			String driver=this.getJdbcDriver();
			String user= this.getUser();
			String pass= this.getPass();

			// Open a connection
			Connection conn = DriverManager.getConnection(driver,user,pass);

			// Execute SQL query
			Statement stmt = conn.createStatement();
			String sql=s;


			int rows = stmt.executeUpdate(sql);
			if(rows==0)
				flag=false;
			else
				flag=true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
}
