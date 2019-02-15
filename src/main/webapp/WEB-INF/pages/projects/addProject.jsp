<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 11.02.2019
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new project</title>
    <script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>
</head>
<body>

<h3>Project Form</h3>
<form id="putProject">
    <pre>
        name: <input type="text" name="name">
        cost: <input type="number" name="cost">
                  <input type="submit" value="Submit">
    </pre>
</form>

<script>
    $("#putProject").submit(function(event){
        event.preventDefault();
        var form = $(this);
        var url = 'http://localhost:8080/springdemo_war_exploded/project/addProject';
        var data = {
            "name": form.find('input[name="name"]').val(),
            "cost": form.find('input[name="cost"]').val(),
        };

        $.ajax({
            method : 'PUT',
            url : url,
            dataType : "json",
            contentType: 'application/json',
            data : JSON.stringify(data),
            success : function(resp){
                alert(resp.response);
                window.location.href = "http://localhost:8080/springdemo_war_exploded/project";
            },
            error: function(){
                alert("Something wrong!");
            }
        });
    });
</script>
</body>
</html>
