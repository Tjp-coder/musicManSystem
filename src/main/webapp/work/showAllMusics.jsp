<%@ page import="service.MusicService" %>
<%@ page import="service.impl.MusicServiceImpl" %>
<%@ page import="bean.Music" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>音乐管理系统 - 音乐管理</title>
    <!-- 引入CSS样式表 -->
    <link rel="stylesheet" href="../css/work/showAllMusics.css">
</head>
<script>
    /**
     * 确认操作函数，根据isDelete参数决定是删除还是修改
     * @param {number} id - 音乐ID
     * @param {boolean} isDelete - 是否执行删除操作
     */
    function confirmDelete(id, isDelete) {
        const confirmMsg = isDelete ? '确定要删除吗？' : '确定要修改吗？';
        if (confirm(confirmMsg)) {
            if (isDelete) {
                window.location.href = 'deleteMusic?id=' + id;
            } else {
                window.location.href = 'findMusicById?id=' + id;
            }
        }
    }
</script>




<body>
<!-- 搜索表单 -->
<form action="showAllMusics" method="post">
    按歌名查找：<input type="text" name="key"/>
    <input type="submit" value="搜索"/>
</form>

<!-- 添加音乐链接 -->
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addMusic.jsp">添加音乐</a>

<%-- 音乐列表展示 --%>
<%
    // 获取session中保存的音乐信息列表
    Object object = session.getAttribute("musicList");
    List<Music> musicList;
    if (object != null) {
        musicList = (List<Music>) object;
    } else {
        musicList = new MusicServiceImpl().queryAll();
    }

    // 输出查询结果
    out.println("<table width='50%' style='border-spacing: 0em;margin-left: 1px;border: 1px solid #220808;border-collapse: collapse;'>");
    out.println("<tr><th>id</th><th>歌名</th><th>演唱者</th><th>排名</th><th>操作</th></tr>");

    for (Music m : musicList) {
        out.println("<tr>");
        out.println("<td>" + m.getId() + "</td>");
        out.println("<td>" + m.getMusicName() + "</td>");
        out.println("<td>" + m.getSinger() + "</td>");
        out.println("<td>" + m.getRanking() + "</td>");
        out.println("<td>");
        out.println("<a href='javascript:void(0);' onclick=\"confirmDelete(" + m.getId() + ", false)\">修改</a>");
        out.println("<a href='javascript:void(0);' onclick=\"confirmDelete(" + m.getId() + ", true)\">删除</a>");
        out.println("</td>");
        out.println("</tr>");
    }
    out.println("</table>");
%>
</body>
</html>
