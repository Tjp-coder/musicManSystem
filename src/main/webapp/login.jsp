<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>音乐管理系统登录页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            text-align: left;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #068cd7;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #068cd7;
        }
        a {
            text-decoration: none;
            color: #068cd7;
        }
        p {
            margin-top: 15px;
            text-align: center;
        }
        .remember{
            display: flex;
            flex-wrap: wrap;
        }
        .error-message {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<form action="login" method="post">
    <h2 style="text-align: center;">Login</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <label for="username">账号:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>
    <div class="remember">
        <input type="checkbox" id="remember" name="remember">
        <label for="remember">记住我(30天免登录)</label>
    </div>

    <input type="submit" value="Login">

    <p>没有账号? <a href="register.jsp">去注册</a></p>
</form>
</body>
</html>
