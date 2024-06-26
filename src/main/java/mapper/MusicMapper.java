package mapper;

import bean.Music;

import java.util.List;

public interface MusicMapper {
    //增删改查
    public List<Music> queryAll() ;

    public List<Music> queryMusicsByKey(String key) ;

    Music findByMusicId(int id);

    public int addMusic(Music music) ;

    public int updateMusic(Music music) ;

    public int deleteMusic(int musicId);
}
