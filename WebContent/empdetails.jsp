<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<h2>Employee Details</h2>

	<form action="empdetails.jsp">
		Employee id : <input type="number" name="id" value="${param.id}" /> <input type="submit"
			value="Details" />
	</form>

	<%
		if (request.getParameter("id") == null)
			return;
	%>

	<jsp:useBean class="beans.EmployeeBean" id="empBean" scope="page" />
	<jsp:setProperty name="empBean" property="id" />
	<%
	  if (empBean.getName() == null)
	  {   
		  out.println("<h3>Employee Not Found </h3>");
		  return;
	  }
	%>
	<h3>
		${empBean.name} <br /> ${empBean.job} <br /> ${empBean.salary}
	</h3>

</body>
</html>