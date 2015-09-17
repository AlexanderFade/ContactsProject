package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.Phone;
import com.alexfade.projects.contacts.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
@Repository
@Transactional
public class PhoneDAOImpl implements PhoneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public PhoneDAOImpl() {

    }

    public PhoneDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Сохраняем телефон пользователя в БД
     * @param userId
     * @param phone
     */
    @Override
    @Transactional
    public void createPhone(Integer userId, Phone phone) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Сохраняем полученный емейл в БД
        session.save(phone);

        // Добавляем емейл пользователю
        // Получаем пользователя по его Id
        User existingUser = session.get(User.class, userId);
        // Подтверждаем обновление данных для существующего пользователя
        existingUser.getPhones().add(phone);

        // Сохраняем изменения
        session.save(existingUser);
    }

    /**
     * Извлекает все телефоны из БД
     * @return
     */
    @Override
    @Transactional
    public List<Phone> getAllPhones() {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Создаем очередь Hibernate (HQL)
        Query query = session.createQuery("FROM Phone");

        // Извлекаем все полученные email в списке
        return query.list();
    }

    /**
     * Извлекает все телефоны пользователя
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public List<Phone> getAllPhonesByUser(Integer userId) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Создаем очередь Hibernate (HQL)
        Query query = session.createQuery("FROM User as p WHERE p.id="+userId);

        User user = (User) query.uniqueResult();

        // Retrieve all
        return  new ArrayList<Phone>(user.getPhones());
    }

    @Override
    public Phone getPhone(Integer phoneId) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Извлекаем существующую почту
        Phone phone = session.get(Phone.class, phoneId);

        // Возвращаем
        return phone;
    }

    @Override
    public void editPhone(Phone phone) {
// Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Извлечение существующей почты по Id
        Phone existingPhone = session.get(Phone.class, phone.getPhoneId());
        // Обновление имени существующей почты
        existingPhone.setPhone(phone.getPhone());
        // Сохранение изменений
        session.save(existingPhone);
    }

    @Override
    public void deletePhone(Integer phoneId) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        Phone forDeletePhone = session.get(Phone.class, phoneId);

        session.delete(forDeletePhone);
    }

    @Override
    public void deleteAllPhonesByUser(Integer userId) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("unchecked")
        List<Phone> phones = (List<Phone>) session.createQuery("FROM Phone as p " +
                "WHERE p.user.id = " + userId).list();

        for(Phone phone : phones) {
            session.delete(phone);
        }
    }
}
