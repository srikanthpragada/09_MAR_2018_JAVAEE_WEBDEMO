<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Cookie</title>
</head>
<body>

	<%
		String name = request.getParameter("cname");
		String value = request.getParameter("cvalue");
		String durable = request.getParameter("durable");  // checkbox

		Cookie c = new Cookie(name, value);
		if (durable != null)  // checkbox is checked 
			c.setMaxAge(7 * 24 * 60 * 60);
		response.addCookie(c);
		out.println("<h3>Cookie is created</h3>");
	%>

</body>
</html>