package com.chanchifeng.controller;

import com.chanchifeng.model.User;
import com.chanchifeng.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("userAction")
@Scope("prototype") //默认是单例模式，需配置多例
public class UserController extends ActionSupport implements ModelDriven<User> {

    private static final Logger log = LogManager.getLogger (UserController.class);

    private User user = new User ();

    @Autowired
    private UserService userService;

    @Override
    public User getModel() {
        return user;
    }

    public String login() {
        String login = userService.login (user);
        System.out.println("...");
        return login;
    }

    public String register() {

        System.out.println (user);
        log.info (user);
        String register = userService.register (user);
        return register;
    }
}
