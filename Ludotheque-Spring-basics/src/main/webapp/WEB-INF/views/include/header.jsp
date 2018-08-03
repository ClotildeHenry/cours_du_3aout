<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="http://localhost:8083/spring-basic/cd/add?lang=en"><img src="https://media.istockphoto.com/photos/national-flag-of-the-united-kingdom-picture-id185692665?k=6&m=185692665&s=612x612&w=0&h=4orKcZRbCA7GB4tpA9dXdSRUOA0bo-b7r74key4dMgU=" border="0" " height="10%" width="10%"> </a>
<a href="http://localhost:8083/spring-basic/cd/add?lang=fr"><img src="https://www.autourdugateau.fr/2340/disque-en-sucre-drapeau-francais.jpg" border="0" " height="5%" width="5%"> </a>
<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8 ">
	<section>
	<div class="d-flex justify-content-between">

	</div>
	</section>
	<section>
	<div class="jumbotron">
		<h1><spring:message code="site.title"/></h1>
		<p><spring:message code="site.undertitle"/></p>	
	</div>
</section>

