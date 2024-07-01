javaEE 课程设计
音乐管理系统
jsp servlet mybatis



# 第一次更新

## 新增功能需求

1. **音乐类别管理**：
    + 增加类别管理功能，包括增删改查类别信息。
    + 更新 `tb_music` 表中的 `category_id` 字段为外键，引用类别表。
2. **用户管理**：
    + 添加用户管理功能，包括查看所有用户信息、修改用户信息、删除用户等。
3. **评论与评分功能**：
    + 增加音乐评论与评分功能，让用户可以对音乐进行评论和评分。
    + 需要新增 `tb_comment` 和 `tb_rating` 表。
4. **播放记录**：
    + 增加用户播放记录功能，记录用户播放过的音乐。
    + 需要新增 `tb_play_record` 表。
5. **搜索功能**：
    + 增加音乐搜索功能，可以根据音乐名、歌手、类别等条件进行搜索。



## 新增文件



**新增类别管理相关文件**：

+ `java/mapper/CategoryMapper.java`
+ `java/service/CategoryService.java`
+ `java/service/impl/CategoryServiceImpl.java`
+ `java/servlet/category/AddCategoryServlet.java`
+ `java/servlet/category/DeleteCategoryServlet.java`
+ `java/servlet/category/UpdateCategoryServlet.java`
+ `java/servlet/category/ShowAllCategoriesServlet.java`
+ `resources/mapper/CategoryMapper.xml`

**新增评论和评分管理相关文件**：

+ `java/mapper/CommentMapper.java`
+ `java/mapper/RatingMapper.java`
+ `java/service/CommentService.java`
+ `java/service/RatingService.java`
+ `java/service/impl/CommentServiceImpl.java`
+ `java/service/impl/RatingServiceImpl.java`
+ `java/servlet/comment/AddCommentServlet.java`
+ `java/servlet/comment/DeleteCommentServlet.java`
+ `java/servlet/comment/ShowAllCommentsServlet.java`
+ `resources/mapper/CommentMapper.xml`
+ `resources/mapper/RatingMapper.xml`

**新增播放记录相关文件**：

+ `java/mapper/PlayRecordMapper.java`
+ `java/service/PlayRecordService.java`
+ `java/service/impl/PlayRecordServiceImpl.java`
+ `java/servlet/record/AddPlayRecordServlet.java`
+ `java/servlet/record/ShowAllPlayRecordsServlet.java`
+ `resources/mapper/PlayRecordMapper.xml`



#### 具体实现建议

1. **前端页面调整**：
    + 在 `webapp/work` 目录下新增类别管理、评论、评分等相关的 JSP 页面。
    + 在 `index.jsp` 中增加相应的导航链接。
2. **后端服务层逻辑**：
    + 在服务层实现相应的业务逻辑，例如音乐类别的增删改查、评论和评分的处理等。
3. **过滤器与拦截器**：
    + 在 `ValidationFilter.java` 中增加对新功能相关请求的过滤和验证。







E-R图



![image-20240626201012703](https://knowledge-1312726591.cos.ap-guangzhou.myqcloud.com/images/markdown%E5%9B%BE%E7%89%87/img/202406262010784.png)







## 整体编写思路

### 整体思路

1. **设置数据库和实体类：**
    + 确保数据库模式已正确设置并插入初始数据。
    + 创建必要的Java实体类（`Category`、`Comment`、`Music`、`PlayRecord`、`Rating`、`User`）。
2. **编写Mapper接口和XML映射文件：**
    + 在`mapper`包中为每个实体类编写Mapper接口（如`CategoryMapper`、`CommentMapper`等）。
    + 在`resources/mapper`目录下创建对应的XML映射文件（如`CategoryMapper.xml`、`CommentMapper.xml`等），定义SQL语句。
3. **实现服务层：**
    + 在`service`包中定义服务接口（如`CategoryService`、`CommentService`等）。
    + 在`service/impl`包中实现这些服务接口（如`CategoryServiceImpl`、`CommentServiceImpl`等）。
4. **实现Servlet层：**
    + 在`servlet`包及其子包中创建Servlet类，处理前端请求。
    + 使用注解`@WebServlet`配置URL映射。
5. **前端页面：**
    + 在`webapp`目录下创建必要的JSP页面（如`addMusic.jsp`、`showAllMusics.jsp`等）。
    + 使用HTML、CSS和JavaScript实现页面样式和交互效果。
    + 在JSP页面中通过JSTL和EL表达式与后端数据交互。





一个个功能实现：

- 重复以上步骤