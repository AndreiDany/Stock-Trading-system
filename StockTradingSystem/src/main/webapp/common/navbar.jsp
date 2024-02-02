<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Navbar (sit on top) -->
<div class="w3-top">
	<div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing: 4px;">
		<a href="<c:url value="/index.jsp"/>" class="w3-bar-item w3-button">Stocks</a>
		<!-- Right-sided links. Hide them on small screens -->
		<div class="w3-right w3-hide-small">
			<a href="<c:url value="/prepareLogin.htm"/>" style="margin-right: 20px;">Login</a>
			<a href="<c:url value="/prepareRegister.htm"/>" style="margin-right: 20px;">Register</a>
			<a href="<c:url value="/portofolio.htm"/>" style="margin-right: 20px;">Portfolio</a>
		</div>
	</div>
</div>