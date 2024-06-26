<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加音乐</title>
    <link rel="stylesheet" href="../css/work/addMusic.css">
</head>
  <body>
  <form method="post" action="addMusicServlet">
      <h2>添加音乐信息</h2>
      <div>
          音乐名称:<input type="text" name="musicName" placeholder="请输入音乐名称" />
      </div>
      <div>
          演唱者:<input type="text" name="singer" placeholder="请输入演唱者" />
      </div>
      <div>
          排名:<input type="text" name="ranking" placeholder="请输入排名" />
      </div>
      <input type="submit" value="添加" />
  </form>


  </body>
</html>
