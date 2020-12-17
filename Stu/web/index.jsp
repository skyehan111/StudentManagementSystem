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
    <link rel="stylesheet" href="Style_1.css" type="text/css">
    <script>
        function toRegister() {
            window.location = "Register.jsp";
        }
    </script>
</head>
<body>
<span style="text-align: center"><h3>欢迎进入学生管理系统</h3></span>
<span style="text-align: center"><h3>管理员请登录</h3></span>
<form method="post" action="LoginServlet">
    <div id="LoginTable" style="text-align: center">
    <table border="1px">
        <tr>
            <td>username:</td>
            <td colspan="2"><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>password:</td>
            <td colspan="2"><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="Login" value="Login">Login</button>
            </td>
            <td>
                <button type="reset" name="Reset" value="Reset">Reset</button>
            </td>
            <td>
                <button type="button" name="Register" value="Register" onclick="toRegister()">Register</button>
            </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>
