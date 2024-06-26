package servlet.music;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import bean.Music;
import service.impl.MusicServiceImpl;

import java.io.IOException;

// 点击修改，修改的id并重定向至修改页面
@WebServlet(urlPatterns = {"/work/findMusicById"})
public class FindMusicByIdServlet extends HttpServlet {

    @SneakyThrows
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        // 查询指定id的音乐信息，并将信息保存到session中
        Music music = new MusicServiceImpl().findByMusicId(Integer.parseInt(id));
        request.getSession().setAttribute("music", music);
        //页面重定向到updateMusic.jsp；
        response.sendRedirect("updateMusic.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
