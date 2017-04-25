package dao;

import model.Chorus;
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
    public static JSONArray getQueryResultSolo(String sql,Connection conn){
        JSONArray soloMusicJson =new JSONArray();
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
                Solo solo = new Solo(id,name,composer,time,status,wordsAuther,singer,accompaniment,vocalType);
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
        System.out.println(soloMusicJson);
        return soloMusicJson;

    }
    public static JSONArray getSoloMusic(Connection conn,String table) throws JSONException {
        String sql = "select * from " + table + "";
        if (table.equals("solo_music")) {
            return getQueryResultSolo(sql, conn);
        }
        else
            return getQueryResultChorus(sql, conn);
    }

    public static JSONArray getMusicSortName(Connection conn,String table) throws JSONException {
        String sql = "select * from "+table+" ORDER BY name ASC";
        if (table.equals("solo_music")) {
            return getQueryResultSolo(sql, conn);
        }
        else
            return getQueryResultChorus(sql, conn);

    }
    public static JSONArray getQueryResultChorus(String sql,Connection conn){
        JSONArray chorusMusicJson =new JSONArray();
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
                String chorusType = rs.getString("chorus_type");
                System.out.println("type"+chorusType);
                String accompaniment= rs.getString("accompaniment");
                String status= rs.getString("disk");
                Chorus chorus = new Chorus(id,name,composer,time,status,wordsAuther,singer,accompaniment,chorusType);
                chorusMusicJson.put(mapper.writeValueAsString(chorus));
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
        System.out.println(chorusMusicJson);
        return chorusMusicJson;

    }
    public static String calculateTime(Connection conn)  {
        String sql = "SELECT SUM(totalTime) AS total from ((SELECT SUM(time)AS totalTime FROM solo_music WHERE disk='on') " +
                "UNION (SELECT SUM(time) AS totalTime FROM chorus_music WHERE disk='on'))AS T";
        PreparedStatement pstm = null;
        int totalTime=0;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            totalTime+=rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(totalTime);
    }
    public static JSONArray getMusicSortSinger(Connection conn,String value) throws JSONException {
        JSONArray musicJson = new JSONArray();
        String sql = "(select id from solo_music WHERE singer='"+value+"')UNION (select id from chorus_music WHERE " +
                "singer='"+value+"')";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                JSONObject obj = new JSONObject();
                obj.put("id", id);
                musicJson.put(obj.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(musicJson.toString());
        return musicJson ;
    }
    public static void addToDisk(Connection conn,String id,String value,String table){
        String sql="UPDATE "+table+" SET disk='"+value+"'  WHERE id = "+id+"";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
