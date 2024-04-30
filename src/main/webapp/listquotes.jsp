<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
  /* CSS to position the button */
  .top-right {
    position: absolute;
    top: 10px; /* Adjust this value to move the button down or up */
    right: 20px; /* Adjust this value to move the button right or left */
  }
</style>
<title>Quotes Management Application</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 <style>
        /* Target the search button */
        .btn-outline-success {
            color: white; /* Set text color to white */
            border-color: white; /* Set border color to white */
        }
         /* Define styles for the search button when active (clicked) */
        .btn-outline-success.active,
        .btn-outline-success:active {
            color: white; /* Set text color to white */
            background-color: blue !important; /* Set background color to blue */
            border-color: blue !important; /* Set border color to blue */
        
    </style>
</head>
<body  background="e.jpg">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black;">
			
	

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listquotes"
					class="nav-link">Quotes</a></li>
				 <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Sort By
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">

          <a class="dropdown-item" href="<%=request.getContextPath()%>/sortby">Z-A</a>
           <a class="dropdown-item" href="#">Most Liked</a>
          <a class="dropdown-item" href="#">Topic</a>
     <!--  <div class="dropdown-divider"></div>  -->    
         
          
        </div>
      </li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
      <div><a href="${pageContext.request.contextPath}/login" class="btn btn-danger my-2 my-sm-0 top-right">log out</a></div>
    </form>
    
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Quotes</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-info">Add
					New Quote</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						
						<th>Contenu</th>
						<th>Auteur</th>
						<th>Source</th>
		
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="quote" items="${listQuote}">

						<tr>
							
							<td><c:out value="${quote.contenu}" /></td>
							<td><c:out value="${quote.auteur}" /></td>
							<td><c:out value="${quote.source}" /></td>
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
