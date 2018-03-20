<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Movies</title>
</head>
<body>
<%
   String city = "";
   for(Cookie c : request.getCookies())
   {
	   if (c.getName().equals("city"))
	   {
		   city = c.getValue();
		   break;
	   }
   }
   
   if (city.length() == 0)  // cookie with name city not found
      response.sendRedirect("takecity.html");
   else
	  out.println("Movies in : " + city);
	   
%>

</body>
</html>