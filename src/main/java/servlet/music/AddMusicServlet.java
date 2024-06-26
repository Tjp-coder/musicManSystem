package servlet.music;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bean.Music;
import lombok.SneakyThrows;
import service.impl.MusicServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/work/addMusicServlet"})
public class AddMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String musicName = req.getParameter("musicName");
        String singer = req.getParameter("singer");
        int ranking = Integer.parseInt(req.getParameter("ranking"));
        Music music = new Music(0, musicName, singer, ranking);
        int result = new MusicServiceImpl().addMusic(music);
        if (result != 0) {
            resp.sendRedirect("showAllMusics");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("添加失败");
        }
    }
}
