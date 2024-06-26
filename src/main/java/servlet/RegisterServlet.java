package servlet;

import java.io.*;

import bean.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // 在后端进行校验
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || name == null || name.isEmpty()) {
            // 校验失败，注册信息不全
            request.setAttribute("error", "注册信息不全，请填写完整");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        UserService userService = new UserServiceImpl();
        boolean success = userService.register(new User(username, password, name, gender, phone, email));

        if (success) {
            response.sendRedirect("login.jsp");
        } else {
            // 注册失败提示注册信息不对，请重新输入
            request.setAttribute("error", "注册信息不对，请重新输入");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }
}