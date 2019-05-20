package com.chanchifeng.action;

import com.alibaba.fastjson.JSONObject;
import com.chanchifeng.model.User;
import com.chanchifeng.service.UserService;
import com.chanchifeng.vo.Pager;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static org.apache.struts2.interceptor.MessageStoreInterceptor.NONE;

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

    /* 分页 */

    //返回前端的JSON字符串，需要提供get/set方法
    private String responseStr;

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }

    //方式二：Ajax+JSON
    public String findAllJSON() {

        System.out.println("findAllJson");

        // 使用struts2的servlet接口，接收request里的参数
        // 商品名字参数
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String uname = request.getParameter("uname");
        String uidStr = request.getParameter("uid");
        Integer uid = null;
        if(uidStr != null && !"".equals(uidStr.trim())){
            uid = Integer.valueOf(uidStr);
        }
        // 取得页面索引
        String pageNumStr = request.getParameter("page");

        int pageNum = 1; // 默认显示第几页数据
        if (pageNumStr != null && !"".equals(pageNumStr.trim())) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = 5; // 默认每页显示多少条记录
        String pageSizeStr = request.getParameter("limit");
        if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装模糊查询条件
        User searchModel  = new User();
        searchModel.setUname(uname);
        searchModel.setUid(uid);

        // 调用service 获取查询结果
        Pager<User> result = userService.findByPage(searchModel, pageNum, pageSize);
        // 将查询结果封装成JSON字符串格式

        result.setStatus(0);

        responseStr = JSONObject.toJSONString(result);
        System.out.println(responseStr);
        // 利用response对象传回前端
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");
        try {
            Writer writer = response.getWriter();
            writer.write(responseStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return NONE;

//        return responseStr;
    }

}
