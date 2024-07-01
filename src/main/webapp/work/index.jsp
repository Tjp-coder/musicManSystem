<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>音乐管理系统 - 控制台</title>
    <link rel="stylesheet" href="../css/work/index.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .top-bar {
            background-color: #4CAF50;
            color: #fff;
            padding: 15px 20px;
            text-align: right;
        }

        .top-bar a {
            color: #fff;
            margin-left: 20px;
            text-decoration: none;
        }

        .container {
            display: flex;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .sidebar {
            width: 200px;
            background-color: #f4f4f4;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar ul li {
            margin-bottom: 10px;
        }

        .sidebar ul li a {
            color: #333;
            text-decoration: none;
            display: block;
            padding: 10px;
            background-color: #e6e6e6;
            border-radius: 3px;
        }

        .sidebar ul li a:hover {
            background-color: #ccc;
        }

        .content {
            flex-grow: 1;
            padding: 20px;
            font-size: 16px;
        }
    </style>

</head>
<body>
<div class="top-bar">
    <span>欢迎, <%= session.getAttribute("username") %></span>
    <a href="../logout">退出登录</a>
</div>
<div class="container">
    <div class="sidebar">
        <ul>
            <li><a href="showAllMusics.jsp">音乐管理</a></li>
            <li><a href="category/index.jsp">音乐类别管理</a></li>
            <li><a href="user/index.jsp">用户管理</a></li>
            <li><a href="comment/index.jsp">评论管理</a></li>
            <li><a href="rating/index.jsp">评分管理</a></li>
            <li><a href="playback/index.jsp">播放记录</a></li>
            <li><a href="search/index.jsp">搜索功能</a></li>
        </ul>
    </div>
    <div class="content">
        <!-- 主内容区域 -->
        <h1>欢迎来到音乐管理系统</h1>
        <p>请选择左侧菜单中的功能进行管理操作。</p>
    </div>
</div>
</body>
</html>
