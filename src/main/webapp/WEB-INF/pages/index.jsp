<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Info</title>
   <%--<link rel="stylesheet" type="text/css" href="../../styles/style.css">--%>
</head>
<body>
    <table>
        <jsp:useBean id="developers" scope="request" type="java.util.List"/>
        <c:forEach items="${developers}" var="developer">
            <tr>
                <td><c:out value="${developer.name}"/></td>
                <td><a href="./${developer.id}">details</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
