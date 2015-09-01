//package com.alexfade.projects.contacts.dao;
//
//import com.alexfade.projects.contacts.domain.Phone;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate4.HibernateTemplate;
//import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
//* Created by Alexander Kovalevsky on 27.08.15.
//* Project name: ContactsProject
//*/
//
//@Repository
//public class PhoneDAOImpl implements PhoneDAO {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public PhoneDAOImpl() {
//
//    }
//
//    public PhoneDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    @Transactional
//    public void create(Phone phone) {
//        sessionFactory.getCurrentSession().save(phone);
//    }
//
//    @Override
//    @Transactional
//    public List<Phone> readAll() {
//        return sessionFactory.getCurrentSession().createQuery("from Phone").list();
//    }
//
//    @Override
//    @Transactional
//    public void update(Phone phone) {
//        sessionFactory.getCurrentSession().update(phone);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Phone phone) {
//        sessionFactory.getCurrentSession().delete(phone);
//    }
//}
