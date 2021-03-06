package com.chanchifeng.service.impl;

import com.chanchifeng.dao.UserDao;
import com.chanchifeng.model.User;
import com.chanchifeng.service.UserService;
import com.chanchifeng.vo.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 依赖Dao
     */
    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public User getUser(Integer uid) {
        return userDao.getUser(uid);
    }

    /**
     * 注入事务管理
     * @param user
     */
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    /*START CURD*/

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly=true)
    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public User queryById(int id) {
        return userDao.queryById(id);
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Override
    public void update(User user) {
        userDao.update(user);
    }

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
    @Transactional(readOnly=true)
    @Override
    public Pager<User> findByPage(User searchModel, int pageNum, int pageSize) {
        Pager<User> result = userDao.findByPage(searchModel, pageNum, pageSize);
        return result;
    }
}
