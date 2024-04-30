<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>log in</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script>
		function hideMessage() {
			document.getElementById("message").style.display = "none";
		}
		setTimeout(hideMessage, 3000);
	</script>
</head>
<body>

	<header>
	<!--	<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Quote Management App </a>
			</div>

			<ul class="navbar-nav">
		
				<li><a href="${pageContext.request.contextPath}/userlist"
					class="nav-link">Users</a></li>
			</ul>
		</nav> -->
	</header>
	<br>
	<div class="container col-md-5">
	
		<div class="card">
			<div class="card-body">
				<div id="message" style="color: red;">${message}</div>
				<c:if test="${user != null}">
					<form action="/userupdate" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="${pageContext.request.contextPath}/loginverif" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
							<a class="btn btn-light" id="t2" href="${pageContext.request.contextPath}">s'authentifier</a>
					<a  class="btn btn-primary" id="t"  href="${pageContext.request.contextPath}/login">se connecter</a>
            			
            		
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				

				<fieldset class="form-group">
					<label> Email</label> <input type="email"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label> Password</label> <input type="password"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>

				<button type="submit" class="btn btn-success">log in</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
