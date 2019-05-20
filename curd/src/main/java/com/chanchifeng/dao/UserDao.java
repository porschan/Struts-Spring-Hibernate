package com.chanchifeng.dao;

import com.chanchifeng.model.User;
import com.chanchifeng.vo.Pager;

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
