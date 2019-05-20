package com.chanchifeng.dao;

import com.chanchifeng.model.User;

import java.util.List;

public interface UserDao {
    User getUser(Integer uid);
    void saveUser(User user);

    /*START CURD*/

    /**
     * 添加
     * @param user
     */
    void addUser(User user);


    /**
     * 查询全部
     * @return
     */
    List<User> queryAll();

    /**
     * 根据编号删除
     * @param id
     */
    void delete(int id);

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    User queryById(int id);

    /**
     * 修改
     * @param user
     */
    void update(User user);

    /*END CURD*/

}
