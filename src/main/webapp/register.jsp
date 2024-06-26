<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <link rel="stylesheet" href="css/register.css">

    <style>
        .required-star {
            color: red; /* 设置星号颜色为红色 */
            font-weight: bold; /* 设置星号为粗体 */
        }
    </style>
</head>
<body>
<!-- 在注册表单之前显示注册错误信息 -->
<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

<form action="register" method="post">
    <h2>Register</h2>
    <label for="username">账号:<span class="required-star">*</span></label>
    <input type="text" id="username" name="username" required placeholder="请输入账号" >

    <label for="password">密码:<span class="required-star">*</span></label>
    <input type="password" id="password" name="password" required placeholder="请输入密码">

    <label for="name">姓名:<span class="required-star">*</span></label>
    <input type="text" id="name" name="name" required placeholder="请输入姓名">

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
