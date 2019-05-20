package com.chanchifeng.dao.impl;

import com.chanchifeng.dao.UserDao;
import com.chanchifeng.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User getUser(Integer uid){
        Session session=sessionFactory.getCurrentSession();
        //当getCurrentSession所在的方法，或者调用该方法的方法绑定了事务之后，session就与当前线程绑定了，也就能通过currentSession来获取，否则就不能。
        User user=session.get(User.class,uid);
        return user;
    }

    @Override
    public void saveUser(User user){
        Session session=sessionFactory.getCurrentSession();
        session.save(user);
        System.out.println("======="+user.getUname());
        //使用getCurrentSession后，hibernate 自己维护session的关闭，写了反而会报错
    }

    /*START CURD*/

    /**
     * 增加数据
     * @param user
     */
    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.save(user);
//        transaction.commit();
//        session.close();
    }

    /**
     * 查询全部数据
     * @return
     */

    @Override
    public List<User> queryAll() {
        Session session = sessionFactory.getCurrentSession();
        List users = session.createQuery("FROM User").list();
        return users;
    }

    /**
     * 根据编号删除
     * @param id
     */
    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class,id));
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @Override
    public User queryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    /*END CURD*/
}
