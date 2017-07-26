<%-- 
    Document   : loginform
    Created on : Apr 28, 2017, 3:29:37 PM
    Author     : Rahul
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="springtag" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form:form action="${pageContext.request.contextPath}/saveUser" method="POST" modelAttribute="User">
            <table>
                <tr>
                    <td><springtag:message code="lable.userId"/>:</td>
                    <td>
                        <form:input path="userId"/>
                    </td>
                    <td>
                        <form:errors path="userId" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td><springtag:message code="lable.password"/>:</td>
                    <td>
                        <form:password path="password"/>
                    </td>
                    <td>
                        <form:errors path="password" cssStyle="color:red"/>
                    </td>
                </tr>
                                <tr>
                    <td>Full Name:</td>
                    <td>
                        <form:input path="fullName"/>
                    </td>
                    <td>
                        <form:errors path="fullName" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td><springtag:message code="lable.emailAddr"/>:</td>
                    <td>
                        <form:input path="emailAddr"/>
                    </td>
                    <td>
                        <form:errors path="emailAddr" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td><springtag:message code="lable.mobile"/>:</td>
                    <td>
                        <form:input path="mobile"/>
                    </td>
                    <td>
                        <form:errors path="mobile" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="addUser" value="Save User Details"/>
                        <input type="submit" name="loginForm"value="Cancel"/>
                    </td>
                </tr>
            </table>
        </form:form>

    </body>
</html>
