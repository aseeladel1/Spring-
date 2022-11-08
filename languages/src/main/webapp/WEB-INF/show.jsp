<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name}</title>
</head>
<body>
	<header>
		<h1>Language Details</h1>
		<a href="/languages">Dashboard</a>
	</header>
	<main>
		<p>
			Name:
			<c:out value="${language.name}" />
		</p>
		<p>
			Creator:
			<c:out value="${language.creator}" />
		</p>
		<p>
			Version:
			<c:out value="${language.version}" />
		</p>
		<p>
			<a href="/edit/${language.id}">Edit</a>
		</p>
		<form action="/languages/delete/${language.id}/" method="post">
			<input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete" />
		</form>


	</main>

</body>
</html>