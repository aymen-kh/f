<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Quotes Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Quote Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Quotes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${quote != null}">
					<form action="<%=request.getContextPath()%>/update" method="post">

				</c:if>
				<c:if test="${quote == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${quote != null}">
            			Edit Quote
            		</c:if>
						<c:if test="${quote == null}">
            			Add New Quote
            		</c:if>
					</h2>
				</caption>

				<c:if test="${quote != null}">
				
					<input type="hidden" name="id" value="<c:out value='${quote.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Quote contenu</label> <textarea
					 class="form-control"
						name="contenu" required="required" rows="4" cols="50"> <c:out value='${quote.contenu}' /></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label>Quote Auteur</label> <input type="text"
						value="<c:out value='${quote.auteur}' />" class="form-control"
						name="auteur">
				</fieldset>

				<fieldset class="form-group">
					<label>Quote source</label> <input type="text"
						value="<c:out value='${quote.source}' />" class="form-control"
						name="source">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>