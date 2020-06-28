<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand">Herbal shop</a>
			</div>

			<ul class="navbar-nav">
				<li>
					<a href="<%=request.getContextPath()%>/list" class="nav-link">Categories</a>
				</li>
			</ul>
			
			<ul class="navbar-nav">
				<li>
					<a page="<%=request.getContextPath()%>/list" class="nav-link">Shopping Page</a>
				</li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li>
					<a href="<%=request.getContextPath()%>/logout" class="nav-link">Logout</a>
				</li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${category != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${category == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${category != null}">Edit Category</c:if>
						<c:if test="${category == null}">Add New Category</c:if>
					</h2>
				</caption>

				<c:if test="${category != null}"><input type="hidden" name="id" value="<c:out value='${category.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Category Title</label> 
					<input type="text" value="<c:out value='${category.title}' />" class="form-control" name="title" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Category Description</label> 
					<input type="text" value="<c:out value='${category.description}' />" class="form-control" name="description" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Category Status</label> 
					<select class="form-control" name="isDone">
						<option value="false">In Progress</option>
						<option value="true">Complete</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Category Target Date</label> 
					<input type="date" value="<c:out value='${category.targetDate}' />" class="form-control" name="targetDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="/MyProjectFiles/UserLoginSignup/footer.jsp"></jsp:include>
</body>
</html>