package service;

import bean.User;

public interface UserService {
    //登录
    public boolean login(User user);
    //注册
    public boolean register(User user);
}
