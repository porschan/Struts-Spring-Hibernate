package com.chanchifeng.service;

import com.chanchifeng.model.User;

import java.util.List;

public interface UserService {
    User getUser(Integer uid);
    void saveUser(User user);

    /*START CURD*/

    void addUser(User user);
    List<User> queryAll();
    void delete(int id);
    User queryById(int id);
    void update(User user);
    /*END CURD*/
}
