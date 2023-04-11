<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
    	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>
 
<h2>Report Manager</h2>
<c:url var="addAction" value="/report/add" ></c:url>

<form:form action="${addAction}" commandName="report" modelAttribute="report">


<h3>${message}</h3>

 <c:if test="${!empty report.tipo}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" /><br>
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
 
 NOMBRE: <form:input path="tipo"/><br>
 <form:errors path="tipo"/>
     
 FOLIO: <form:input path="folio"/><br>
 <form:errors path="folio"/>

COMENTARIO<form:textarea path="comentario"/><br>     

 <c:if test="${!empty report.tipo}">
                <input type="submit"
                    value="<spring:message text="Edit Report"/>" />
            </c:if>

<c:if test="${empty report.tipo}">
                <input type="submit"
                    value="<spring:message text="Add Report"/>" />
            </c:if>
</form:form>
     

    <h3>REPORTS</h3>
<table class="data" border="1">
<tr>
    <th>ID</th>
    <th>TIPO</th>
    <th>FOLIO</th>
    <th>COMENTARIO</th>
    <th>REMOVE</th>
    <th>EDIT</th>
</tr>
<c:forEach items="${reportList}" var="report">
    <tr>
        <td>${report.id}</td>
        <td>${report.tipo}</td>
        <td>${report.folio}</td>
        <td>${contact.comentario}</td>
	<td><a href="<c:url value='/delete/${report.id}'/>">Delete</a></td>
	<td><a href="<c:url value='/edit/${report.id}'/>">Edit</a></td>
    </tr>
</c:forEach>
</table>     
</body>
</html>