<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	
	<body>
		<f:view>
		Spring REST Demo
		<hr>
						
		<a href="${pageContext.request.contextPath}/api/customers">[1] Show list of all customers</a>
		<br></br>
		<a href="${pageContext.request.contextPath}/api/customers/Id/1">[2] Show just one customer by id (id=1)</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/api/customers/city/Vancouver">[3] Show list of customers based on the city(Vancouver)</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/api/customers/sorted/family">[4] Show list of customers ordered by family</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/api/customers/find/Sinck">[5] Find a customer or customers by family(Sinck)</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/api/customers/typeofcard/VISA/state/AB">[6] Find a customer or customers by type of card(VISA) and state(AB) (Extra feature)</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/api/customers/delete/M">[7] Delete a customer or customers by gender(M) (Extra feature)</a>
		<br><br>
		
		</f:view>
	</body>
</html>