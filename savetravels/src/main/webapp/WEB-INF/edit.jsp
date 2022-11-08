<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Expense</h1><a href="/expenses">Go back</a>
	<form:form action="/edit/${expense.id}" method="post"
		modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="name">Expense Name: </form:label>
			<br />
			<form:errors path="name" class="text-danger" />
			<form:input path="name" />
		</div>

		<div>
			<form:label path="vendor">Vendor: </form:label>
			<br />
			<form:errors path="vendor" class="text-danger" />
			<form:input path="vendor" />
		</div>

		<div>
			<form:label path="amount">Amount: </form:label>
			<br />
			<form:errors path="amount" class="text-danger" />
			<form:input type="double" path="amount" />
		</div>

		<div>
			<form:label path="description">Description: </form:label>
			<br />
			<form:errors path="description" class="text-danger" />
			<form:textarea path="description" />
		</div>

		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>