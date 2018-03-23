<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*,oracle.jdbc.rowset.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
</head>
<body>
	<h1>List Of Jobs</h1>
	<%
		CachedRowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from jobs");
		rs.execute();
	%>
	<table width="100%" border='1'>
		<tr style="background-color:gray">
			<th>Id</th>
			<th>Title</th>
			<th>Min Salary</th>
			<th>Max Salary</th>
		</tr>

		<%
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString("job_id") + "</td>");
				out.println("<td>" + rs.getString("job_title") + "</td>");
				out.println("<td>" + rs.getString("min_salary") + "</td>");
				out.println("<td>" + rs.getString("max_salary") + "</td></tr>");
			}
		   rs.close();
		%>
	</table>

</body>
</html>