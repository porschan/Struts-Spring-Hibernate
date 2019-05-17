package com.chanchifeng.dao;

import com.chanchifeng.model.User;

public interface UserDao {

    void save(User user);

    User find(String username, String password);
}
