package com.chanchifeng.dao.impl;


import com.chanchifeng.dao.UserDao;
import com.chanchifeng.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository()
@Scope("prototype")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory (sessionFactory);
    }

    @Override
    public void save(User user) {
        if (this.getHibernateTemplate () == null) {
            System.out.println ("getHibernateTemplate == null");
        }
        this.getHibernateTemplate ().save (user);
    }
    @Override
    public User find(String username, String password) {
        List<User> users = (List<User>) this.getHibernateTemplate ().find ("from User where username=? and password=?", username, password);
        if (users.size () > 0) {
            return users.get (0);
        }
        return null;
    }
}
