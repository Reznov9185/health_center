<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" import="java.util.Date,java.lang.*" %>

<!DOCTYPE html>
<html>
	
<head>
	<title> Login :: Health Care</title>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
		<!--//webfonts-->
</head>
<body>
	
				 <!-----start-main---->
				<div class="login-form">
					<div class="head">
						<img src="images/mem2.jpg" alt=""/>
						
					</div>
				<s:if test="hasActionErrors()">
				<div class="errors">
				  <s:actionerror/>
				</div>
				</s:if>
				<s:form action="login" method="post">
					<li>
						<a href="#" class=" icon user"></a>
						<s:textfield  name="username" class="text" value="USERNAME" label="USER NAME" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" />
					</li>
					<li>
						<a href="#" class=" icon lock"></a>
						<s:password  name="password" value="Password"/>
					</li>
					<div class="p-container">
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Remember Me</label>
								<input type="submit" onclick="myFunction()" value="SIGN IN" >
					</div>
				</s:form>
			</div>
			<!--//End-login-form-->
		 		
</body>
</html>