<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 11.02.2019
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>

</head>
<body>

<div id ="list" class="list"></div>
<a href="http://localhost:8080/springdemo_war_exploded/project/addProject">Add new project</a>

<script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>
<script>
    $.ajax({
        url : "http://localhost:8080/springdemo_war_exploded/project/all",
        method : "GET",
        dataType: "json",
        type : "application/json",
        success : function(resp) {
            drawProjects(resp);
        },
        error : function() {
            alert("Something wrong!");
        }
    });

    function drawProjects(projects) {
        for(var x = 0; x < projects.length; x++) {
            var child = $("<div>\n"+
                "<label>Id: "+projects[x].id+"</label>\n"+
                "<label>, Name: "+projects[x].name+"</label>\n"+
                "<label>, Birthday: "+projects[x].birthday+"</label>\n"+
                "<label>, Cost: "+projects[x].cost+"</label>\n"+
                "</div>");
            $("#list").append(child);
        }
    }
</script>
</body>
</html>
