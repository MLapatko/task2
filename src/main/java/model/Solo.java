package model;

import java.sql.Time;

/**
 * Created by user on 16.03.2017.
 */
public class Solo extends VocalMusic {
    String vocalType;

    public Solo(int id,String name, String composer, int time, String wordsAuther, String singer, String accompaniment,
                String vocalType,String status) {
        this.id=id;
        this.name=name;
        this.composer=composer;
        this.time=time;
        this.wordsAuther=wordsAuther;
        this.singer=singer;
        this.accompaniment=accompaniment;
        this.vocalType = vocalType;
        this.status=status;
    }

    public String getVocalType() {
        return vocalType;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("\n#############################")
                .append("\nНазвание композиции: " )
                .append(this.name)
                .append("\nКомпозитор: ")
                .append(this.composer )
                .append("\nВремя: ")
                .append(this.time)
                .append("\nАвтор слов: ")
                .append(this.wordsAuther)
                .append("\nИсполнитель: ")
                .append(this.singer)
                .append("\nТип вокала: ")
                .append(this.vocalType)
                .append("\nАккомпанемент: ")
                .append(this.accompaniment);
        return sb.toString();
    }
}
