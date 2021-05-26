<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script>
        window.onload=function (){
            document.getElementById("img").onclick=function (){
                this.src="/myWeb/CheckCodeServlet?time"+new Date().getTime();
            }
        }
    </script>
</head>
<body>
</h1>
<br/>

<form action="/myWeb/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkcode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/myWeb/CheckCodeServlet"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
</form>
<hr>
<a href="/myWeb/dowloadServlet?filename=好看.png">图片1</a>
<hr>
<%--<div><%=request.getAttribute("cc_error")==null? "": request.getAttribute("cc_error") %></div>--%>
${requestScope.cc_error}

</body>
</html>