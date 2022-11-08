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
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td>$<c:out value="${expense.amount}"></c:out></td>
					<td><a href="/edit/${expense.id}">edit</a></td>
					<td>
				<form action="/expenses/delete/${expense.id}/" method="post">
				    <input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" />
				</form>
				</td>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
		<h1>Add an expense:</h1>
		<form:form action="/expenses" method="post" modelAttribute="expense">

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

			<div>
				<input type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>
