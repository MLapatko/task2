package model;

/**
 * Created by user on 16.03.2017.
 */
public class Solo extends VocalMusic {
    String vocalType;

    public Solo(int id, String name, String composer, int time, String status, String wordsAuther, String singer, String accompaniment, String vocalType) {
        super(id, name, composer, time, status, wordsAuther, singer, accompaniment);
        this.vocalType = vocalType;
    }

    public String getVocalType() {
        return vocalType;
    }
}
