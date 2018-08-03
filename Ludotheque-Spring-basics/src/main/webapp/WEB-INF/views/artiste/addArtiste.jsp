<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:import url="../include/header.jsp" />

<spring:url value="/artiste/add" var="artisteAdd" />
<spring:url value="/artiste/list" var="artisteList" />

<section class="container">

	<h3>Gestion des artistes <small> > ${action} </small></h3>
	<p>
		<a href="${artisteList}">Retour à la liste des artistes</a>
	</p>
	
	<form:form method="POST" action="${artisteAdd}" modelAttribute="artiste">
	
	<spring:hasBindErrors name="artiste">
		<div class="alert alert-danger" role="alert">
			<form:errors path="nom" cassClass="error" element="div"/>
			<form:errors path="prenom" cassClass="error" element="div"/>
		</div>
	
	</spring:hasBindErrors>
	
				<form:hidden path="id" />
				<div class="form-group">
					<label for="prenom"> prenom </label>
					<form:input path="prenom" class="form-control" placeholder="Entrez le nom ici"/>
				</div>
				<div class="form-group">
					<label for="nom">nom</label>
				    <form:input path="nom" class="form-control" placeholder="Entrez le prénom ici"/>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</section>
<c:import url="../include/footer.jsp" />