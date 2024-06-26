package mapper;

import bean.User;

import java.util.List;

public interface UserMapper {
    User findUserByUser(User user);
    List<User> findAllUsers();
    int insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
