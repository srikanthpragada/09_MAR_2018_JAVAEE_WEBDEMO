<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*,oracle.jdbc.rowset.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employees</title>
</head>
<body>
	<h1>Search Employees</h1>
	<form action="searchemployees.jsp">
		Name : <input type="text" name="ename" value="${param.ename}" />
		<input type="submit" value="Search" />
	</form>
    <p></p>
	<%
		String ename = request.getParameter("ename");
		if (ename == null)
			return; // terminate JSP 

		CachedRowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select e.first_name, j.job_title, d.department_name, e.salary from employees e join jobs j using(job_id) join departments d using(department_id) where first_name like ? order by first_name");
		rs.setString(1, "%" + ename + "%");
		rs.execute();
		
		if (!rs.next())  // Check whether rs has any rows 
		{
			out.println("<h3>Sorry! No employees found!</h3>");
			return;
		}
		
		rs.beforeFirst(); // take pointer back to beginning 
	%>
	<table width="100%" border='1'>
		<tr style="background-color: gray">
			<th>First Name</th>
			<th>Job</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>

		<%
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString("first_name") + "</td>");
				out.println("<td>" + rs.getString("job_title") + "</td>");
				out.println("<td>" + rs.getString("department_name") + "</td>");
				out.println("<td>" + rs.getString("salary") + "</td></tr>");
			}
			rs.close();
		%>
	</table>

</body>
</html>