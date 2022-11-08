<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name}</title>
</head>
<body>
	<header>
		<h1>Edit Language</h1>
		<a href="/languages">Delete</a> - <a href="/languages">Dashboard</a>
	</header>
	<form:form action="/edit/${language.id}" method="post"
		modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="name">Name: </form:label>
			<br />
			<form:errors path="name" />
			<form:input path="name" />
		</div>

		<div>
			<form:label path="creator">Creator: </form:label>
			<br />
			<form:errors path="creator" />
			<form:input path="creator" />
		</div>

		<div>
			<form:label path="version">Version: </form:label>
			<br />
			<form:errors path="version" />
			<form:input type="double" path="version" />
		</div>

		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>