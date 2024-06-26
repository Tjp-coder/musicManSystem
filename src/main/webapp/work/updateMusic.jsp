<%@ page import="bean.Music" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改音乐信息 </title>
    <link rel="stylesheet" href="../css/work/updateMusic.css">
</head>
  <body>
    <%
     //获取session中保存的音乐信息
        Music music = new Music();
        Object object = request.getSession().getAttribute("music");
        if (object instanceof Music) {
            music = (Music) object;
        }
    %>

   <!--显示并可修改指定id的音乐信息，点击提交按钮，跳转到UpdateMusicServlet文件-->
    <form method="post" action="updateMusic">
        <h2> 修改音乐信息</h2>
        <input type="hidden" value="<%=music.getId()%>" name="id"/>
    	音乐名称:<input type="text" name="musicname" value="<%=music.getMusicName()%>"/><br/>
    	演唱者:<input type="text" name="singer" value="<%=music.getSinger()%>"/><br/>
        排名：<input type="text" name="ranking" value="<%=music.getRanking()%>"/><br/>
    	<input type="submit" value="修改">
    </form>

  </body>
</html>