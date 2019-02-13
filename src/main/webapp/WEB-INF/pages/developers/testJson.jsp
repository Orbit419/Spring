<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 31.01.2019
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json</title>
</head>
<body>
<div id ="mylist" class="list"></div>

<script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>

<script>
    $.ajax({
       url: "http://localhost:8080/springdemo_war_exploded/developer/all",
       method: "GET",
       success: function (resp) {
           console.log("Get all developers response:"+resp);
           drawDevs(resp);
       },
       error: function(error) {
           console.log("Error:"+error)
       },
       dataType: "json"
    });

    function drawDevs(developers) {
        for(var i = 0; i < developers.length; i++) {
            var child = $("<div>\n"+
                    "<label>"+developers[i].id+"</label>\n"+
                    "<label>"+developers[i].name+"</label>\n"+
            "</div>");
            $("#mylist").append(child);
        }
    }
</script>
</body>
</html>
