<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.srikanthtechnologies.com/mar9" prefix="st" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using Job Tags</title>
</head>
<body>
  <h2>List Of Jobs</h2>
  <select>
    <st:jobs3>
     <option value="${id}">${title}</option>
     </st:jobs3>
  </select>
  <p></p>
  <ul>
  <st:jobs3>
   <li>${title} - ${minSalary} </li>
  </st:jobs3>
  </ul>
  
   

</body>
</html>