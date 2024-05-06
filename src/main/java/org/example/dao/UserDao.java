package org.example.dao;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getUserList();

    User getUserById(String name);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);

    int insertUserByMap(Map<String,Object> map);
}
