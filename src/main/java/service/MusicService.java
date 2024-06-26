package service;

import bean.Music;

import java.util.List;

public interface MusicService {
    //增删改查
    public List<Music> queryAll() throws Exception;

    public List<Music> queryMusicsByKey(String key) throws Exception;

    Music findByMusicId(int id) throws Exception;

    public int addMusic(Music music) throws Exception;

    public int updateMusic(Music music) throws Exception;

    public int deleteMusic(int musicId) throws Exception;
}
