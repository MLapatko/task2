package model;

import java.io.Serializable;
import java.sql.Time;

/**
 * Created by user on 16.03.2017.
 */
public class Music implements Serializable{
    int id;
     String name;
     String composer;
     int time;
    String status;
    public Music(){};
    public Music(int id, String name, String composer, int time,String status) {
        this.id = id;
        this.name = name;
        this.composer = composer;
        this.time = time;
        this.status=status;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTime() {
        return time;
    }

    public int getId() {return id;}

    public String getName() {
        return name;
    }

    public String getComposer() {
        return composer;
    }

    public void play(){
        System.out.println("Music is playing");
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("\n#############################")
                .append("\nНазвание композиции = " )
                .append(this.name)
                .append("\nКомпозитор = ")
                .append(this.composer )
                .append("\nВремя = ")
                .append(this.time);
        return sb.toString();
    }
}
