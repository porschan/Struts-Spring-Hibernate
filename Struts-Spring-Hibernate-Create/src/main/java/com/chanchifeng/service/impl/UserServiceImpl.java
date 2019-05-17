package com.chanchifeng.service.impl;

import com.chanchifeng.dao.UserDao;
import com.chanchifeng.model.User;
import com.chanchifeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


@Service()
@Scope("prototype")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String login(User user) {
        User user1 = userDao.find (user.getName (), user.getPassword ());
        if (user1 != null) {
            return "success";
        }
        return "not found";
    }

    @Override
    public String register(User user) {
        userDao.save (user);
        return "success";
    }

}
