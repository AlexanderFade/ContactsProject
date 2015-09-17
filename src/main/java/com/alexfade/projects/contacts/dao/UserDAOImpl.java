package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public UserDAOImpl() {

    }

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public List<User> readAll() {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("unchecked")
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        User existingUser = session.get(User.class, user.getUserId());

        existingUser.setLogin(user.getLogin());
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setSecond_name(user.getSecond_name());

        session.save(existingUser);
    }

    @Override
    @Transactional
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();

        User forDeleteUser = session.get(User.class, user.getUserId());

        session.delete(forDeleteUser);
    }

    @Override
    @Transactional
    public void deleteById(Integer user_id) {
        Session session = sessionFactory.getCurrentSession();

        User userForDelete = new User();
        userForDelete.setUserId(user_id);
        session.delete(userForDelete);
    }

    @Override
    @Transactional
    public User getUser(Integer userId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(User.class, userId);
    }


}
