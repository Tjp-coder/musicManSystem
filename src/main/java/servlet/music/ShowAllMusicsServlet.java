package servlet.music;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bean.Music;
import lombok.SneakyThrows;
import service.MusicService;
import service.impl.MusicServiceImpl;

import java.io.IOException;
import java.util.List;

/*该Servlet用来查询所有音乐信息，并使用session保存所有音乐信息，保存之后跳转到showAllMusics.jsp文件
* */
@WebServlet(urlPatterns = {"/work/showAllMusics"})

public class ShowAllMusicsServlet extends HttpServlet {
    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key = request.getParameter("key");
        //查询所有音乐信息
        MusicService musicService= new MusicServiceImpl();
        List<Music> musicList = musicService.queryMusicsByKey(key);
        //使用session保存所有音乐信息，保存之后跳转到showAllMusics.jsp文件；
        request.getSession().setAttribute("musicList", musicList);
        //跳转到showAllMusics.jsp文件；
        response.sendRedirect("showAllMusics.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
