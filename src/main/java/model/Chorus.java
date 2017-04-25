package model;

/**
 * Created by user on 16.03.2017.
 */
public class Chorus extends VocalMusic {
    String chorusType;

    public String getChorusType() {
        return chorusType;
    }

    public void setChorusType(String chorusType) {
        this.chorusType = chorusType;
    }

    public void play(){
        System.out.println("Chorus is singing");
    }

    public Chorus(int id, String name, String composer, int time, String status, String wordsAuther, String singer,
                  String accompaniment, String chorusType) {
        super(id, name, composer, time, status, wordsAuther, singer, accompaniment);
        this.chorusType = chorusType;
    }
}
