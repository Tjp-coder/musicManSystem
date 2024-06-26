package service.impl;

import bean.User;
import mapper.MusicMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import util.MybatisUtils;


public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl() {
        SqlSession sqlSession = MybatisUtils.getSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public boolean login(User user) {
        User userByUser = userMapper.findUserByUser(user);
        System.out.println(userByUser);
        return  userByUser !=null;
    }

    @Override
    public boolean register(User user) {
        int rows = userMapper.insertUser(user);
        return rows > 0;
    }
}
