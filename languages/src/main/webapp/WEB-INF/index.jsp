<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Languages</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${languages}">
				<tr>
					<td><a href="/languages/${language.id}"><c:out value="${language.name}"></c:out></a></td>
					<td><c:out value="${language.creator}"></c:out></td>
					<td><c:out value="${language.version}"></c:out></td>
					<td><a href="/edit/${language.id}">edit</a></td>
					<td>
				<form action="/languages/delete/${language.id}/" method="post">
				    <input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" />
				</form>
				</td>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
		<h1>Add a Language:</h1>
		<form:form action="/languages" method="post" modelAttribute="language">

			<div>
				<form:label path="name">Name: </form:label>
				<br/>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name"/>
			</div>

			<div>
				<form:label path="creator">Creator: </form:label>
				<br/>
				<form:errors path="creator" class="text-danger"/>
				<form:input path="creator"/>
			</div>

			<div>
				<form:label path="version">Version: </form:label>
				<br/>
				<form:errors path="version" class="text-danger"/>
				<form:input type="double" path="version"/>
			</div>

			<div>
				<input type="submit" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>