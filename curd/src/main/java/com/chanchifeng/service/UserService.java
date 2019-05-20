package com.chanchifeng.service;

import com.chanchifeng.model.User;
import com.chanchifeng.vo.Pager;

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

    /**
     * 根据查询条件，查询商品分页信息
     *
     * @param searchModel
     *            封装查询条件
     * @param pageNum
     *            查询第几页数据
     * @param pageSize
     *            每页显示多少条记录
     * @return 查询结果
     */

    Pager<User> findByPage(User searchModel, int pageNum, int pageSize);
}
