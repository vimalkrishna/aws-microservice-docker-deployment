<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>


<h1>Vehicles page</h1>

<ul>
<c:forEach items="${vehicles}" var="vehicle">
   <li><a href="<c:url value="/website/vehicles/vehicle/${vehicle.name}"/>">${vehicle.name}</a></li>
</c:forEach>
</ul>
</body>
</html>