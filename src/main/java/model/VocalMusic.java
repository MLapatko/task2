package model;

/**
 * Created by user on 16.03.2017.
 */
public class VocalMusic extends Music {
    String wordsAuther;
    String singer;
    String accompaniment;

    public VocalMusic(int id, String name, String composer, int time, String status, String wordsAuther, String singer,
                      String accompaniment) {
        super(id, name, composer, time, status);
        this.wordsAuther = wordsAuther;
        this.singer = singer;
        this.accompaniment = accompaniment;
    }

    @Override
    public void play(){
        System.out.println("The singer is singing");
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getWordsAuther() {
        return wordsAuther;
    }

    public String getAccompaniment() {
        return accompaniment;
    }

}
