package servlet;

import bean.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember"); // 获取“记住我”复选框的值

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        if (userService.login(user)) {
            // 登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            if (rememberMe != null && rememberMe.equals("on")) {
                // 创建一个持久性的 cookie，设置有效期为30天
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(30 * 24 * 60 * 60); // 设置有效期为30天
                response.addCookie(cookie);
            }

            response.sendRedirect("work/index.jsp"); // 重定向到欢迎页面
        } else {
            // 登录失败
            request.setAttribute("errorMessage", "账号或密码错误，请重新输入。");
            request.getRequestDispatcher("login.jsp").forward(request, response); // 转发到登录页面，并附带错误参数
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
