<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
    <title>All Tickets</title>
</head>
<body>

<style type="text/css">
    .layout { overflow: hidden; }
    .layout DIV { float: left; }
    .col1 {width: 30%; }
    .col2 {width: 40%; }
    .col3 {width: 30%; }
</style>
</head>
<div class="layout">
    <div class="col1"> <c:set var="status" value="TO DO" /><h1></h1>
        <table>
            <td><b>${status}</b>
                <tr>
                    <td><b>Name</b></td>
                    <td><b>Description</b></td>
                    <td><b>Action</b></td>
                </tr>
                <c:forEach var="ticket" items="${tickets}">
                    <tr>
                        <c:if test = "${ticket.status==status}">
                            <td>${ticket.name}</td>
                            <td>${ticket.description}</td>
                            <td><a href="/edit?id=${ticket.id}">Edit</a> | <a href="/delete?id=${ticket.id}">Delete</a></td>
                            <td><a href="/markAsInProgress?id=${ticket.id}">Mark as In Progress</a> | <a href="/markAsDone?id=${ticket.id}">Mark as Done</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5">
                        <a href="/add?status=${status}">New Ticket</a>
                    </td>
                </tr>
            </td></table></div>


    <div class="col2">  <c:set var="status" value="In Progress" /><h1></h1>
        <table>
        <td><b>${status}</b>
            <tr>
                <td><b>Name</b></td>
                <td><b>Description</b></td>
                <td><b>Action</b></td>
            </tr>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <c:if test = "${ticket.status==status}">
                       <td>${ticket.name}</td>
                        <td>${ticket.description}</td>
                        <td><a href="/edit?id=${ticket.id}">Edit</a> | <a href="/delete?id=${ticket.id}">Delete</a> | </td>
                        <td><a href="/markAsToDo?id=${ticket.id}">Mark as TO DO</a> | <a href="/markAsDone?id=${ticket.id}">Mark as Done</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <a href="/add?status=${status}">New Ticket</a>
                </td>
            </tr>
        </td></table></div>


    <div class="col3"> <c:set var="status" value="Done" /><h1></h1>
        <table>
        <td><b>${status}</b>
            <tr>
                <td><b>Name</b></td>
                <td><b>Description</b></td>
                <td><b>Action</b></td>
            </tr>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <c:if test = "${ticket.status==status}">
                        <td>${ticket.name}</td>
                        <td>${ticket.description}</td>
                        <td><a href="/edit?id=${ticket.id}">Edit</a> | <a href="/delete?id=${ticket.id}">Delete</a></td>
                        <td><a href="/markAsToDo?id=${ticket.id}">Mark as TO DO</a> | <a href="/markAsInProgress?id=${ticket.id}">Mark as In Progress</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <a href="/add?status=${status}">New Ticket</a>
                </td>
            </tr>
        </td>
            </table>
        </div>
</div>
<form action="<c:url value="/logout"/>" method="post">
    <input type="submit" value="Logoff"/> (also clears any remember-me cookie)
    <security:csrfInput/>
</form>
</body>
</html>
