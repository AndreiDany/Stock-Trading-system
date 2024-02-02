<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<title>Stocks</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<jsp:include page="/common/headStyles.jsp" />

<style>
a {
	text-decoration: none;
}

.button {
	color: white;
	padding: 10px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.buttonBlack {
	background-color: white;
	color: black;
	border: 2px solid #555555;
}
</style>

</head>

<body>

	<jsp:include page="/common/navbar.jsp" />

	<!-- Page content -->
	<header class="w3-display-container w3-content w3-wide"
		style="max-width: 1600px; min-width: 500px" id="home">
		<img class="w3-image" src="img/imgHome1.jpg" alt="Stocks image"
			width="1600" height="800">
		<div class="w3-display-bottomleft w3-padding-large w3-opacity">
			<h1 class="w3-xxlarge" style="text-color: white">Stocks</h1>
		</div>
		<div class="w3-display-middle w3-padding-large text-center"
			style="top: 70%;">
			<a href="<c:url value="/stocksList.htm"/>">
				<button class="button buttonBlack">
					<h5>Stocks List</h5>
				</button>
			</a>
		</div>
	</header>

	<!-- Footer -->
	<jsp:include page="/common/footer.jsp" />

</body>
</html>
