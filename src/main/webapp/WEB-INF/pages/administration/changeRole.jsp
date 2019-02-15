<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 11.02.2019
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="user" scope="request" type="mate.academy.springdemo.model.userDto.UserAdminOutput"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change role</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
<form id="changeRole">
    <pre>
        Username: ${user.userName}
        Role:     ${user.role}
        New role: <input type="text" name="newRole">
                  <input type="submit" value="Submit">
    </pre>
</form>

<script>
    $("#changeRole").submit(function(changeRole) {
        changeRole.preventDefault();
        var form = $(this);
        var data = {
            "id": ${user.id},
            "role": form.find('input[name="newRole"]').val()
        };
        $.ajax({
            url: "http://localhost:8080/springdemo_war_exploded/admin/changeRole",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(resp) {
                window.location.href = resp.response;
            },
            error: function() {
                alert("Something wrong");
            }
        });
    });
</script>
</body>
</html>
