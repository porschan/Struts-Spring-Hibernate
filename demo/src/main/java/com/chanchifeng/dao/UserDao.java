package com.chanchifeng.dao;

import com.chanchifeng.model.User;

public interface UserDao {
    User getUser(Integer uid);
    void saveUser(User user);
}
