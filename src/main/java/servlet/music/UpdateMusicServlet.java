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


@WebServlet(urlPatterns = {"/work/updateMusic"})
public class UpdateMusicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取updateMusic.jsp文件中所输入的音乐信息，根据id修改音乐姓名
        int id = Integer.parseInt(req.getParameter("id"));
        String musicName = req.getParameter("musicname");
        String singer = req.getParameter("singer");
        int rank = Integer.parseInt(req.getParameter("ranking"));
        Music music = new Music(id, musicName, singer, rank);
        int result = new MusicServiceImpl().updateMusic(music);
        if (result > 0) {
            //跳转到ShowAllMusicsServlet文件；
            resp.sendRedirect("showAllMusics");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.print("修改失败");
        }
    }
}
