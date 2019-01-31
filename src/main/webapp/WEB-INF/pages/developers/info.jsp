<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 27.01.2019
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="developer" scope="request" type="mate.academy.springdemo.model.dto.DeveloperOutput"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Developer By Id</title>
</head>
<body>
<h2>
    <table>
        <tr>
            <td>Id :</td>
            <td>${developer.id}</td>
        </tr>
        <tr>
            <td>Name :</td>
            <td>${developer.name}</td>
        </tr>
        <tr>
            <td>Age :</td>
            <td>${developer.age}</td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td>${developer.salary}</td>
        </tr>
    </table>
</h2>
</body>
</html>
