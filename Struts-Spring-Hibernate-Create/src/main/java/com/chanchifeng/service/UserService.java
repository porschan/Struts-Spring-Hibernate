package com.chanchifeng.service;

import com.chanchifeng.model.User;

public interface UserService {
    String login(User user);

    String register(User user);
}
