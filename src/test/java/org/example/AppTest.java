package org.example;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserDao;
import org.example.pojo.User;
import org.example.utils.MybatisUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AppTest {
    @Test
    public void xirstMybatisTest() {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();

        userList.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void selectById() {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        User jack = mapper.getUserById("jack");
        System.out.println(jack);
    }

    @Test
    public void insertUser() {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        int sophia = mapper.insertUser(new User("Sophia", "Love you!"));
        sqlsession.commit();
        if (sophia == 1) {
            System.out.println("Insert sucessfully !");
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        int i = mapper.updateUser(new User("Sophia", "hello"));

        sqlsession.commit();
        if (i == 1) {
            System.out.println();
            System.out.println("Sucessfully!");
        }
    }

    @Test
    public void deleteUser(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        int i = mapper.deleteUser(new User("Flp", "32423"));
        sqlsession.commit();
        if (i == 1) {
            System.out.println("Sucessfully");
        }
    }

    @Test
    public void insertByMap() {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Map<String, Object> stringObjectMap = new HashMap<String, Object>();
        stringObjectMap.put("username", "jackw");
        stringObjectMap.put("password", "jackFlp");
        int i = mapper.insertUserByMap(stringObjectMap);
        sqlsession.commit();

        if (i == 1) {
            System.out.println("Good!");
        }
    }

}

