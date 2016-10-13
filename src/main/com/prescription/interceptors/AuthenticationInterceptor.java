package com.prescription.interceptors;

import java.util.Map;
 
import com.prescription.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
 
public class AuthenticationInterceptor implements Interceptor {
 
    @Override
    public void destroy() {
        //release resources here
    }
 
    @Override
    public void init() {
        // create resources here
    }
 
    @Override
    public String intercept(ActionInvocation actionInvocation)
            throws Exception {
        Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
         
        User user = (User) sessionAttributes.get("user");
         
        if(user == null){
            return Action.LOGIN;
        }else{
            Action action = (Action) actionInvocation.getAction();
            if(action instanceof DoctorAware && user.getUsertype().equals("doctor")){
                return actionInvocation.invoke();
            }     
            else if(action instanceof PatientAware && user.getUsertype().equals("patient")){
                return actionInvocation.invoke();
            }
            else return Action.LOGIN;               
        }
    }
 
}