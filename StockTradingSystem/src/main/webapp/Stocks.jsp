<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Stocks</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<jsp:include page="/common/headStyles.jsp" />

<style>
.button {
	background-color: white;
	border: 2px solid #555555;
	color: black;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.mini-button {
	padding: 2px 3px;
	font-size: 3px;
	margin: 2px 1px;
}
</style>

</head>

<body>

	<jsp:include page="/common/navbar.jsp" />


	<!-- Page content -->
	<div class="w3-content" style="max-width: 1100px">

		<!-- Stocks Section -->

		<br>
		<br>
		<h1 class="w3-center">Stocks</h1>
		<br>

		<div class="w3-row-padding">
			<c:forEach var="stock" items="${model.stocks}">
				<div class="w3-third w3-margin-bottom">
					<div class="w3-card" style="text-align: center;">
						<header class="w3-container w3-light-grey">
							<h4>${stock.name}</h4>
						</header>
						<div class="w3-container">
							<p>
								<strong>Price:</strong> ${stock.price} EUR
							</p>
							<p>
								<strong>Ticker Symbol:</strong> ${stock.tickerSymbol}
							</p>
							<p>
								<strong>Quantity:</strong> ${stock.quantity}
							</p>
						</div>
						<footer class="w3-container w3-light-grey"
							style="display: flex; justify-content: center; align-items: center;">
							<a
								href="<c:url value='addToPortfolio.htm?id=${stock.id}&quantity=1'/>"
								class="button mini-button">
								<h6>Add to portfolio</h6>
							</a>
						</footer>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>


	<!-- Footer -->
	<jsp:include page="/common/footer.jsp" />

</body>
</html>