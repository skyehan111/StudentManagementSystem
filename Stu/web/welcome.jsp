<%--
  Created by IntelliJ IDEA.
  User: skye
  Date: 2020/12/13 013
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="Style_1.css">
</head>
<body>
<div  class="word">欢迎</div><div class="word"><h5>${username}</h5></div><div class="word">进入学生管理系统</div>
<div  class="link">请选择显示方式</div>
<div  class="link"><a href="StudentListServlet">显示所有学生列表</a></div>
<div  class="link"><a href="StudentListPageServlet?currentPage=1">分页显示所有学生</a></div>
</body>
</html>
