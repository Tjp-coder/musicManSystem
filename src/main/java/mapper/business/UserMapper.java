package mapper;
import bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User getUserByUsernameAndPassword(Map<String,String> map);
}
