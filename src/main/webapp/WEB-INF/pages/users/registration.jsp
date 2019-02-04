<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 02.02.2019
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>
</head>
<body>

<h3>Registration</h3>

<form id="reg">
    <pre>
        Login:    <input type="text" name="login">
        Password: <input type="text" name="password">
        Mail:     <input type="text" name="mail">
                  <input type="submit" value="Submit">
    </pre>
</form>

<script>
    $("#reg").submit(function(registration){
        registration.preventDefault();
        var form = $(this);
        var url = "http://localhost:8080/springdemo_war_exploded/user/registration";
        var data = {
            "login": form.find('input[name="login"]').val(),
            "password": form.find('input[name="password"]').val(),
            "mail": form.find('input[name="mail"]').val()
        };

        $.ajax({
           method: "POST",
           url: url,
           traditional : true,
           data: JSON.stringify(data),
           contentType: "application/json",
           dataType: "json",
           success: function(resp) {
               alert(resp.response);
           },
            error: function() {
               alert("Something wrong!");
           }
        });
    });
</script>
</body>
</html>
