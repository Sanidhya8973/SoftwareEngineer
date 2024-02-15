package _02__AOP_Terms.model.beans;

public class Song {

    private String name;
    private String singer;

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

}
