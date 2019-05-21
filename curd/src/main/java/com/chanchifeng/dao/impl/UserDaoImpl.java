package com.chanchifeng.dao.impl;

import com.chanchifeng.dao.UserDao;
import com.chanchifeng.model.User;
import com.chanchifeng.vo.Pager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 分页
     * @param searchModel
     *            封装查询条件
     * @param pageNum
     *            查询第几页数据
     * @param pageSize
     *            每页显示多少条记录
     * @return
     */


    @Override
    public Pager<User> findByPage(User searchModel, int pageNum, int pageSize) {

        // 声明结果集
        Pager<User> result = null;

        // 存放查询参数
        Map<String, Object> paramMap = new HashMap<String, Object>();

        Integer uid = searchModel.getUid();
        String uname = searchModel.getUname();

        StringBuilder hql = new StringBuilder("FROM User WHERE 1=1");
        StringBuilder countHql = new StringBuilder("SELECT COUNT(uid) FROM User WHERE 1=1 ");


        if (uid != null && !uid.equals("")) {
            hql.append(" AND uid = :uid ");
            countHql.append("  AND uid = :uid ");
            paramMap.put("uid", uid);
        }

        if (uname != null && !uname.equals("")) {
            hql.append(" AND uname LIKE :uname ");
            countHql.append(" AND uname LIKE :uname ");
            paramMap.put("uname", "%" + uname + "%");
        }

        // 起始索引
        int fromIndex = pageSize * (pageNum - 1);

        // 存放所有查询出的商品对象
        List<User> productList = new ArrayList<User>();

        Session session = null;

        // 获取被Spring托管的session
        session = sessionFactory.getCurrentSession();

        // 获取query对象
        Query hqlQuery = session.createQuery(hql.toString());
        Query countHqlQuery = session.createQuery(countHql.toString());

        // 设置查询参数
        setQueryParams(hqlQuery, paramMap);
        setQueryParams(countHqlQuery, paramMap);

        // 从第几条记录开始查询
        hqlQuery.setFirstResult(fromIndex);

        // 一共查询多少条记录
        hqlQuery.setMaxResults(pageSize);

        // 获取查询的结果
        productList = hqlQuery.list();

        // 获取总记录数
        List<?> countResult = countHqlQuery.list();
        int totalRecord = ((Number) countResult.get(0)).intValue();

        // 获取总页数
        int totalPage = totalRecord / pageSize;
        if (totalRecord % pageSize != 0) {
            totalPage++;
        }

        // 组装pager对象
        result = new Pager<User>(pageSize, pageNum, totalRecord, totalPage, productList);

        return result;
    }

    /**
     * 设置查询的参数
     *
     * @param query
     * @param paramMap
     * @return
     */
    private Query setQueryParams(Query query, Map<String, Object> paramMap) {
        if (paramMap != null && !paramMap.isEmpty()) {
            for (Map.Entry<String, Object> param : paramMap.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        return query;
    }

}
