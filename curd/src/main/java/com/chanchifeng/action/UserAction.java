package com.chanchifeng.action;

import com.chanchifeng.model.User;
import com.chanchifeng.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    private User user;

    @Resource
    private UserService userService;

    public User getUser(){
        return user;
    }
    public String m1(){
        user=userService.getUser(1);
        System.out.println(user.getUname());
        return SUCCESS;
    }
    public String saveUser(){
        User user=new User();
        user.setUname("事务已提交");
        userService.saveUser(user);
        return SUCCESS;
    }

}