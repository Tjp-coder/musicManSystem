package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//过滤work项目下所有的网站
@WebFilter("/work/*")
public class ValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        boolean login_Flag = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                login_Flag = true;
                // 将用户名存储到会话中
                ((HttpServletRequest) servletRequest).getSession().setAttribute("user", cookie.getValue());
            }
        }
        //无session会话和登录的cookie 重定向至登录页
        if (session.getAttribute("user") == null && !login_Flag) {
            ((HttpServletResponse) servletResponse).sendRedirect("../login.jsp");
        }
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
