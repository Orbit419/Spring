<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 31.01.2019
  Time: 14:22
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
        Password: <input type="test" name="password">
                  <input type="submit" value="Enter">
    </pre>
</form>
<br/>
<div id="result"></div>

<script>
    $("#logIn").submit(function(event){
        event.preventDefault();
        var form = $(this);
        var url = 'http://localhost:8080/springdemo_war_exploded/developer/login';
        var login = form.find('input[name="login"]').val();
        var password = form.find('input[name="password"]').val();

        $.ajax({
            type : 'POST',
            url : url,
            contentType: 'application/x-www-form-urlencoded',
            data : "login="+login+"&password="+password,
            success : function(data, status, xhr){
                $("#result").html(data);
            },
            error: function(xhr, status, error){
                alert(error);
            }
        });
    });
</script>

</body>
</html>
