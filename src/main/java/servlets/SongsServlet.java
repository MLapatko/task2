package servlets;

import dao.JDBCUtils;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Created by user on 20.04.2017.
 */
@WebServlet(urlPatterns = "/songs", loadOnStartup = 1)
public class SongsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        if(request.getParameter("actionType")!=null){
            System.out.println("action="+request.getParameter("actionType"));
            if(request.getParameter("actionType").equals("sort")){
                String parameter=request.getParameter("parameter");
              //  System.out.println(JDBCUtils.colculateTime(conn));
                try {

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(String.valueOf(JDBCUtils.getSoloMusicSortName(conn)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            else if(request.getParameter("actionType").equals("sortSinger")){
                String parameter=request.getParameter("parameter");
                try {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(String.valueOf((JDBCUtils.getSoloMusicSortSinger(conn,parameter))));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if(request.getParameter("actionType").equals("showAll")) {
                try {

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(String.valueOf(JDBCUtils.getSoloMusic(conn)));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
        else {

            request.getRequestDispatcher("/songs.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        String val=request.getParameter("status");
        String id=request.getParameter("key");
        System.out.println("key"+val);
        JDBCUtils.addToDisk(conn,id,val);
        PrintWriter printWriter  = response.getWriter();
        printWriter.println(val);
        printWriter.close();
    }
}
