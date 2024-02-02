<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Portofolio</title>

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
		<h1 class="w3-center">My portofolio</h1>
		<br>

		<div class="w3-row-padding">
			<c:forEach var="portofolioItem" items="${model.myPortofolios}">
				<div class="w3-third w3-margin-bottom">
					<div class="w3-card" style="text-align: center;">
						<header class="w3-container w3-light-grey">
							<h4>${portofolioItem.stock.name}</h4>
						</header>
						<div class="w3-container">
							<p>
								<strong>Price:</strong> ${portofolioItem.stock.price} EUR
							</p>
							<p>
								<strong>Ticker Symbol:</strong>
								${portofolioItem.stock.tickerSymbol}
							</p>
							<p>
								<strong>Quantity:</strong> ${portofolioItem.quantity}
							</p>
						</div>
						<footer class="w3-container w3-light-grey"
							style="display: flex; justify-content: center; align-items: center;">
							<a
								href="<c:url value='sellFromPortfolio.htm?id=${portofolioItem.id}'/>"
								class="button mini-button">
								<h6>Sell</h6>
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