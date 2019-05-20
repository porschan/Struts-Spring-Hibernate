package com.chanchifeng.action;

import com.chanchifeng.model.User;
import com.chanchifeng.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller("curdAction")
@Scope("prototype")
public class CurdAction {

    private Integer uid;
    private String uname;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Resource
    private UserService userService;

    public String queryAll(){
        System.out.println("queryAll");
        List<User> users = userService.queryAll();
        HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
        httpServletRequest.setAttribute("users",users);
        return SUCCESS;
    }

    public String delete(){
        userService.delete(uid);
        System.out.println("删除的uid:" + uid);
        return SUCCESS;
    }

    public String queryById(){
        User user = userService.queryById(uid);
        HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
        httpServletRequest.setAttribute("user",user);
        return "success";
    }

    public String update(){
        user = new User();
        user.setUid(uid);
        user.setUname(uname);
        userService.update(user);
        return "success";
    }

    public String add(){
        user = new User();
        user.setUname(uname);
        System.out.println(user.toString() + "!!");
        userService.addUser(user);
        return "success";
    }

}
