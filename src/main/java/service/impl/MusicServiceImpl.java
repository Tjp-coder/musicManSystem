package service.impl;

import bean.Music;
import mapper.MusicMapper;
import org.apache.ibatis.session.SqlSession;
import service.MusicService;
import util.MybatisUtils;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    private final MusicMapper musicMapper;

    public MusicServiceImpl() {
        SqlSession sqlSession = MybatisUtils.getSession();
        musicMapper = sqlSession.getMapper(MusicMapper.class);
    }
    @Override
    public List<Music> queryAll() throws Exception {
        return musicMapper.queryAll();
    }

    @Override
    public List<Music> queryMusicsByKey(String key) throws Exception {
        return musicMapper.queryMusicsByKey(key);
    }

    @Override
    public Music findByMusicId(int id) throws Exception {
        return musicMapper.findByMusicId(id);
    }

    @Override
    public int updateMusic(Music music) throws Exception {
        int rows = musicMapper.updateMusic(music);
        return rows;
    }

    @Override
    public int addMusic(Music music) throws Exception {
        int rows = musicMapper.addMusic(music);
        System.out.println("----------------:"+rows);
        return rows;
    }

    @Override
    public int deleteMusic(int id) throws Exception {
        int rows = musicMapper.deleteMusic(id);
        System.out.println("----------------:"+rows);
        return rows;
    }
}
