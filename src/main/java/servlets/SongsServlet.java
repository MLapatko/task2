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
        String table;
        if(request.getParameter("actionType")!=null){
            System.out.println("action="+request.getParameter("actionType"));
            if(request.getParameter("actionType").equals("sort")){
                if(request.getParameter("id").equals("solo")){
                    table="solo_music";
                }
                else{
                    table="chorus_music";
                }
                try {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(String.valueOf(JDBCUtils.getMusicSortName(conn,table)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            else if(request.getParameter("actionType").equals("sortSinger")){
                String parameter=request.getParameter("parameter");
                try {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(String.valueOf((JDBCUtils.getMusicSortSinger(conn,parameter))));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if(request.getParameter("actionType").equals("showAll")) {
                System.out.println("servlet");
                if(request.getParameter("id").equals("#solo")){
                    table="solo_music";
                }
                else{
                    table="chorus_music";
                }
                try {

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(String.valueOf(JDBCUtils.getSoloMusic(conn,table)));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            else if(request.getParameter("actionType").equals("calculateTime")) {
                    response.getWriter().println(String.valueOf(JDBCUtils.calculateTime(conn)));

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
        String table;
        if(request.getParameter("id").equals("solo")){
            System.out.println("if block solo");
            table="solo_music";
        }
        else{
            table="chorus_music";
        }
        JDBCUtils.addToDisk(conn,id,val,table);
        PrintWriter printWriter  = response.getWriter();
        printWriter.println(val);
        printWriter.close();
    }
}
