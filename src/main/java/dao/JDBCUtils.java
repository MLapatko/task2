package dao;

import model.Solo;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by user on 23.04.2017.
 */
public class JDBCUtils {
    private static JDBCConnectionPool connectionPool;

    public static JDBCConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            Properties props = readProperties("jdbc.properties");
            connectionPool = new JDBCConnectionPool(
                    props.getProperty("jdbc.Driver"),
                    props.getProperty("jdbc.url"),
                    props.getProperty("jdbc.user"),
                    props.getProperty("jdbc.password")
            );
        }

        return connectionPool;
    }

    private static Properties readProperties(String fileResourceName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = JDBCUtils.class.getClassLoader().getResourceAsStream(fileResourceName);
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public static JSONArray getSoloMusic(Connection conn) throws JSONException {
        JSONArray soloMusicJson =new JSONArray();
        String sql = "select * from solo_music";
        PreparedStatement pstm = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String composer = rs.getString("composer");
                int time = rs.getInt("time");
                String wordsAuther = rs.getString("words_auther");
                String singer = rs.getString("singer");
                String vocalType = rs.getString("vocal_type");
                String accompaniment= rs.getString("accompaniment");
                String status= rs.getString("disk");
                Solo solo = new Solo(id,name,composer,time,wordsAuther,singer,accompaniment,vocalType,status);
                soloMusicJson.put(mapper.writeValueAsString(solo));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return soloMusicJson;
    }
    public static JSONArray getSoloMusicSortName(Connection conn) throws JSONException {
        JSONArray soloMusicJson = new JSONArray();
        String sql = "select * from solo_music ORDER BY name ASC";
        PreparedStatement pstm = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String composer = rs.getString("composer");
                int time = rs.getInt("time");
                String wordsAuther = rs.getString("words_auther");
                String singer = rs.getString("singer");
                String vocalType = rs.getString("vocal_type");
                String accompaniment= rs.getString("accompaniment");
                String status= rs.getString("disk");
                Solo solo = new Solo(id,name,composer,time,wordsAuther,singer,accompaniment,vocalType,status);
                soloMusicJson.put(mapper.writeValueAsString(solo));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return soloMusicJson ;
    }
   /* public static String colculateTime(Connection conn)  {

        String sql = "SELECT CAST(t.time_sum/3600 AS VARCHAR(2))+ CAST(t.time_sum%3600/60 AS VARCHAR(2)) + ':' + CAST(((t.time_sum%3600)%60) AS VARCHAR(2)) AS totalTime FROM ( SELECT SUM(DATEDIFF(S, '00:00:00', time)) AS time_sum  FROM solo_music) t";
        PreparedStatement pstm = null;
        String totalTime="";
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            totalTime=rs.getString(String.valueOf("totalTime"));

            System.out.println("time=" + totalTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalTime;
    }*/
    public static JSONArray getSoloMusicSortSinger(Connection conn,String value) throws JSONException {
        JSONArray soloMusicJson = new JSONArray();
        String sql = "select id from solo_music WHERE singer='"+value+"'";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                JSONObject obj = new JSONObject();
                obj.put("id", id);
                System.out.println("obj"+obj.toString());
                soloMusicJson.put(obj.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soloMusicJson ;
    }
    public static void addToDisk(Connection conn,String id,String value){
        String sql="UPDATE solo_music SET disk='"+value+"'  WHERE id = "+id+"";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
