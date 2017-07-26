<%-- 
    Document   : viewUsers
    Created on : May 2, 2017, 12:45:17 PM
    Author     : Rahul
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Full Name</th>
        <th>Mobile Number</th>
        <th>Email Id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.fullName}</td>
            <td>${user.mobile}</td>
            <td>${user.emailAddr}</td>
            <td><a href="editUser/${user.userId}"/>Edit</td>
            <td><a href="deleteUser/${user.userId}"/>Delete</td>
        </tr>
    </c:forEach>
</table>
<form:form action="userForm" method="POST">
    <input type="submit" name="addUser" value="Add User"/>
</form:form>

