<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1>List Cookies</h1>

<%
    for(Cookie c : request.getCookies())
    {
    	out.println(c.getName() + " - " + c.getValue()  + "<p/>");
    }
%>

</body>
</html>