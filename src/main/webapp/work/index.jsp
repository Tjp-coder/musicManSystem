<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页</title>
    <link rel="stylesheet" href="../css/work/index.css">
    <script src="../js/countdown.js"></script>
</head>

<body onload="countdown()">
<div class="container">
    <h2>尊敬的${sessionScope.user}，登录成功 欢迎你！</h2>
    <h2 id="countdown">3秒后进入系统 ... </h2>
</div>
</body>
</html>
