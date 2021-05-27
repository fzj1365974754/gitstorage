<%--
  Created by IntelliJ IDEA.
  User: fang zhijun
  Date: 2021/5/7
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div>div1</div>
<div>div2</div>
<input type="button" value="点我" id="b1">
<script>
    $(function(){
        $("#b1").click(function(){
            alert("abc");
        })
    })
</script>
</body>
</html>
