<%@ page import="java.util.ArrayList" %>
<%@ page import="com.domain.Users" %><%--
  Created by IntelliJ IDEA.
  User: fang zhijun
  Date: 2021/5/4
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list",list);
    request.setAttribute("num",3);
%>
${requestScope.list[0]}
<c:if test="${not empty list}">
    遍历集合
</c:if>
<c:if test="${num % 2!=0}">
    ${requestScope.num}为奇数
</c:if>


<%
    ArrayList list1 = new ArrayList();
    Users users = new Users();
    users.setUsername("loli");
    users.setPassword("123");
    users.setEmail("321");
    Users users1 = new Users();
    users1.setUsername("chill");
    users1.setPassword("123456");
    users1.setEmail("321456");
    list1.add(users);
    list1.add(users1);
    request.setAttribute("list1",list1);
%>
<table border="1" width="500" align="center">
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>邮箱</th>
    </tr>
    <c:forEach items="${list1}" var="user" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr bgcolor="aqua">
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
            </tr>
        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="#d2691e">
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
