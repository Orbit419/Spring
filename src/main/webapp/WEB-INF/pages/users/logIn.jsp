<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 01.02.2019
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>
</head>
<body>

<form id="logIn">
    <pre>
        Log In
        Login: <input type="text" name="login">
        Password: <input type="text" name="password">
                  <input type="submit" value="Enter">
    </pre>
</form>
<br/>
<div id="result"></div>

<script>
    $("#logIn").submit(function (event) {
        event.preventDefault();
        var form = $(this);
        var url = "http://localhost:8080/springdemo_war_exploded/user/login";
        var data = {
            "login": form.find('input[name="login"]').val(),
            "password": form.find('input[name="password"]').val()
        };

        $.ajax({
           method: 'POST',
           url: url,
           traditional : true,
           contentType: "application/json",
           dataType: "json",
           data: JSON.stringify(data),
           success: function(response) {
               console.log(response);
               alert(response.response);
           },
           error: function() {
               alert("Something wrong!");
           }
        });
    });
</script>
</body>
</html>
