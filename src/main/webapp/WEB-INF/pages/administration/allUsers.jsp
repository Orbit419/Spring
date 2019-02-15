<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 11.02.2019
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>

<div id ="mylist" class="list"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
    $.ajax({
        url: "http://localhost:8080/springdemo_war_exploded/admin/all",
        method: "GET",
        dataType: "json",
        type : "application/json",
        success: function (resp) {
            console.log("Get all users response:"+resp);
            drawUsers(resp);
        },
        error: function(error) {
            console.log("Error:"+error)
        }
    });

    function drawUsers(users) {
        for(var i = 0; i < users.length; i++) {
            var child = $("<div>\n"+
                "<label>Username: "+users[i].userName+"</label>\n"+
                "<label>, role: " + users[i].role + "</label>\n"+
                    "<a href='http://localhost:8080/springdemo_war_exploded/admin/changeRole/"+
                    users[i].id+"'>"+ "Change role</a>\n"+
                "</div>");
            $("#mylist").append(child);
        }
    }
</script>
</body>
</html>
