<%--
  Created by IntelliJ IDEA.
  User: skye
  Date: 2020/12/17 017
  Time: 7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form method="post" action="RegisterServlet">
    <table border="1" width="600" style="margin: auto">
        <tr>
            <td>
                username:
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                password:
            </td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit">submit</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
