package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl() {

    }

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public List<User> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @Transactional
    public void deleteById(Integer user_id) {
        User userForDelete = new User();
        userForDelete.setUserId(user_id);
        sessionFactory.getCurrentSession().delete(userForDelete);
    }

    @Override
    @Transactional
    public User getUser(Integer userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }


}
