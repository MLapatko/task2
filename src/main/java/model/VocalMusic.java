package model;

/**
 * Created by user on 16.03.2017.
 */
public class VocalMusic extends Music {
    String wordsAuther;
    String singer;
    String accompaniment;
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

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("\n#############################")
                .append("\nНазвание композиции = " )
                .append(this.name)
                .append("\nКомпозитор = ")
                .append(this.composer )
                .append("\nВремя = ")
                .append(this.time)
                .append("\nАвтор слов = ")
                .append(this.wordsAuther)
                .append("\nИсполнитель = ")
                .append(this.singer)
                .append("\nАккомпанемент = ")
                .append(this.accompaniment);
        return sb.toString();
    }
}
