<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>Spring Calculator</p>


<c:url var="formUrl" value="/calculator" />

<form:form method="POST" modelAttribute="calculatorCommand" action="${formUrl}"> 

	<table>
		<tr>
			<td><input type="text" id="numberOne" name="numberOne" /></td>
			<td> + </td>
			<td><input type="text" id="numberTwo" name="numberTwo" /></td>
			<td><input type="submit" value="=" /></td>
			<td><c:if test="${not empty result}">${result}</c:if></td>
		</tr>
	</table>
</form:form>

