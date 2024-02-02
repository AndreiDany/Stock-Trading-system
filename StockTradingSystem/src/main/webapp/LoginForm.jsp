<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Login</title>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<jsp:include page="/common/headStyles.jsp" />

<style>
.button {
	background-color: black;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>

</head>
<body>

	<jsp:include page="/common/navbar.jsp" />

	<!-- Page content -->
	<div class="w3-content" style="max-width: 1100px">

		<!-- Login form -->
		<div class="w3-container w3-padding-64">

			<h1>Login</h1>
			<br>

			<form:form action="login.htm" method="post" modelAttribute="user">

				<p>
					Email:
					<form:input class="w3-input w3-padding-16" path="email" />
				</p>
				<p>
					Password:
					<form:input class="w3-input w3-padding-16" path="password" />
				</p>
				<br>

				<button type="submit" class="button">Login</button>

			</form:form>

		</div>

	</div>

	<!-- Footer -->
	<jsp:include page="/common/footer.jsp" />

</body>
</html>