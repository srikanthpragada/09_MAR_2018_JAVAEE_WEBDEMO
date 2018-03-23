<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sessions Demo</title>
</head>
<body>
     
	<%
		String act = request.getParameter("act");
		String key, value;
		key = request.getParameter("key");

		if (act.equals("Add")) {
			value = request.getParameter("value");
			session.setAttribute(key, value); // add attribute 
		} else
			session.removeAttribute(key);  // remove attribute

		// display session variables
		out.println("<h3>Available Session Variables</h3>");
		java.util.Enumeration e = session.getAttributeNames();

		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			value = session.getAttribute(key).toString();
			out.println(key + " : " + value + "<br/>");
		} // end of while
	%>

</body>
</html>