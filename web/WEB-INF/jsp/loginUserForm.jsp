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
        <form:form action="${pageContext.request.contextPath}/userAuth" method="POST" modelAttribute="User">
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
                    <td colspan="2">
                        <input type="submit" name="authUser" value="Login"/>
                        <input type="submit" name="addUser" value="Register User"/>
                    </td>
                </tr>
            </table>
        </form:form>

    </body>
</html>
