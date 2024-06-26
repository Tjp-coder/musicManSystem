package service.impl;

import bean.User;
import mapper.MusicMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import util.MybatisUtils;


public class UserServiceImpl implements UserService {

    @Override
    public boolean login(User user) {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userByUser = mapper.findUserByUser(user);
            return userByUser != null;
        }
    }

    @Override
    public boolean register(User user) {



        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int rows = mapper.insertUser(user);
            sqlSession.commit(); // 提交事务
            return rows > 0;
        }
    }
}
