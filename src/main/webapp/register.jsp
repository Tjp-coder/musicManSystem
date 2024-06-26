<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <link rel="stylesheet" href="css/register.css">

</head>
<body>
<form action="register" method="post">
    <h2>Register</h2>
    <label for="username">账号:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>

    <label for="name">姓名:</label>
    <input type="text" id="name" name="name">

    <label for="gender">性别:</label>
    <select id="gender" name="gender">
        <option value="0">Male</option>
        <option value="1">Female</option>
        <option value="-1">Other</option>
    </select>

    <label for="phone">手机:</label>
    <input type="text" id="phone" name="phone">

    <label for="email">邮箱:</label>
    <input type="email" id="email" name="email">

    <input type="submit" value="Register">

    <a href="login.jsp">已经有账号? 去登录</a>
</form>
</body>
</html>
