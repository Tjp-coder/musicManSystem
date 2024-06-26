package bean;

import lombok.Data;

import java.util.Date;

@Data
public class Music {
    private Integer id;
    private String musicName;
    private String singer;
    private Integer ranking;


    public Music() {
    }

    public Music(Integer id, String musicName, String singer, Integer ranking) {
        this.id = id;
        this.musicName = musicName;
        this.singer = singer;
        this.ranking = ranking;
    }
}
