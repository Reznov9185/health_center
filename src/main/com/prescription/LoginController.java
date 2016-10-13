package com.prescription;

import com.prescription.models.*;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;

@ParentPackage("mainprescription")
@InterceptorRef("defaultStack")
public class LoginController extends ActionSupport implements SessionAware, ModelDriven<Object>{
	private User model = new User();	
	private UsersService usersService = new UsersService();
	
	public HttpHeaders index()
	{		
		return new DefaultHttpHeaders("index");
	}
	
	public HttpHeaders create() {
	  if((model = usersService.checkAuth(model)) != null)
	  {
        sessionAttributes.put("user", model);
        addActionMessage("New schedule created successfully");
        return new DefaultHttpHeaders("success");
	  }
	  else
	  {
	  	return new DefaultHttpHeaders("input");
	  }
	}

	private Map<String, Object> sessionAttributes = null;
 
    @Override
    public void setSession(Map<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
     
    @Override
    public User getModel() {
        return model;
    }
}