//package com.alexfade.projects.contacts.dao;
//
//import com.alexfade.projects.contacts.domain.Email;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
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
//public class EmailDAOImpl implements EmailDAO{
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public EmailDAOImpl() {
//
//    }
//
//    public EmailDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    @Transactional
//    public void create(Email email) {
//        sessionFactory.getCurrentSession().save(email);
//    }
//
//    @Override
//    @Transactional
//    public List<Email> readAll() {
//        return sessionFactory.getCurrentSession().createQuery("from Email ").list();
//    }
//
//    @Override
//    @Transactional
//    public void update(Email email) {
//        sessionFactory.getCurrentSession().update(email);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Email email) {
//        sessionFactory.getCurrentSession().delete(email);
//    }
//}
