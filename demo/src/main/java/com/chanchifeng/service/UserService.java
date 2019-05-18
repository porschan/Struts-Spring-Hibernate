package com.chanchifeng.service;

import com.chanchifeng.model.User;

public interface UserService {
    User getUser(Integer uid);
    void saveUser(User user);
}
