<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 31.01.2019
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>
</head>
<body>

<form id="delete">
    <pre>
        Delete developer
        id: <input type="text" name="id">
                  <input type="submit" value="Submit">
    </pre>
</form>
<br/>
<div id="result"></div>
<script>
    $("#delete").submit(function(event){
        event.preventDefault();
        var form = $(this);
        var id = form.find('input[name="id"]').val();
        var url = 'http://localhost:8080/springdemo_war_exploded/developer/'+id;

        $.ajax({
            type : 'DELETE',
            url : url,
            contentType: 'application/x-www-form-urlencoded',
            data : "id="+id,
            success : function(data, status, xhr){
                $("#result").html(data+
                    " link: <a href='"+url+"'>"+url+"</a>");
            },
            error: function(xhr, status, error){
                alert(error);
            }
        });
    });
</script>

</body>
</html>
