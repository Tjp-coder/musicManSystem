package service.impl;

import bean.Music;
import mapper.MusicMapper;
import org.apache.ibatis.session.SqlSession;
import service.MusicService;
import util.MybatisUtils;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Override
    public List<Music> queryAll() {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
            return mapper.queryAll();
        }
    }

    @Override
    public List<Music> queryMusicsByKey(String key) {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
            return mapper.queryMusicsByKey(key);
        }
    }

    @Override
    public Music findByMusicId(int id) {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
            return mapper.findByMusicId(id);
        }
    }

    @Override
    public int updateMusic(Music music) {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
            int rows = mapper.updateMusic(music);
            sqlSession.commit(); // 提交事务
            return rows;
        }
    }

    @Override
    public int addMusic(Music music) {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
            int rows = mapper.addMusic(music);
            sqlSession.commit(); // 提交事务
            return rows;
        }
    }

    @Override
    public int deleteMusic(int id) {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
            int rows = mapper.deleteMusic(id);
            sqlSession.commit(); // 提交事务
            return rows;
        }
    }
}
