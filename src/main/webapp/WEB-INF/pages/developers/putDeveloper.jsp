<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 30.01.2019
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<script src="../../../resources/jquery-3.3.1.js"></script>--%>
    <script src="<c:url value="/resources/jquery-3.3.1.js" />"></script>
</head>
<body>

<h3>Developer Form</h3>
<form id="putDeveloper">
    <pre>
        name: <input type="text" name="name">
        age: <input type="text" name="age">
        salary: <input type="text" name="salary">
                  <input type="submit" value="Submit">
    </pre>
</form>
<br/>
<div id="result"></div>

<script>
    $("#putDeveloper").submit(function(event){
        event.preventDefault();
        var form = $(this);
        var url = 'http://localhost:8080/springdemo_war_exploded/developer/put';
        var name = form.find('input[name="name"]').val();
        var age = form.find('input[name="age"]').val();
        var salary = form.find('input[name="salary"]').val();

        $.ajax({
            type : 'PUT',
            url : url,
            contentType: 'application/x-www-form-urlencoded',
            data : "name="+name+"&age="+age+"&salary="+salary,
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
