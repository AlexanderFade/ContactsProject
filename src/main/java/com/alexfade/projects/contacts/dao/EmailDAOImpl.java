package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.Email;
import com.alexfade.projects.contacts.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* Created by Alexander Kovalevsky on 27.08.15.
* Project name: ContactsProject
*/

@Repository
@Transactional
public class EmailDAOImpl implements EmailDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public EmailDAOImpl() {

    }

    public EmailDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Записывает почту для пользователя в БД
     * @param userId
     * @param email
     */
    @Override
    @Transactional
    public void createEmail(Integer userId, Email email) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Сохраняем полученный емейл в БД
        session.save(email);

        // Добавляем емейл пользователю
        // Получаем пользователя по его Id
        User existingUser = session.get(User.class, userId);
        // Подтверждаем обновление данных для существующего пользователя
        existingUser.getEmails().add(email);

        // Сохраняем изменения
        session.save(existingUser);
    }

    /**
     * Возвращает все почты записанные в БД
     * @return
     */
    @Override
    @Transactional
    public List<Email> getAllEmails() {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Создаем очередь Hibernate (HQL)
        Query query = session.createQuery("FROM Email");

        // Извлекаем все полученные email в списке
        return query.list();
    }

    /**
     * Извлекает все почты пользователя
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public List<Email> getAllEmailsByUser(Integer userId) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Создаем очередь Hibernate (HQL)
        Query query = session.createQuery("FROM User as p WHERE p.id="+userId);

        User user = (User) query.uniqueResult();

        // Retrieve all
        return  new ArrayList<Email>(user.getEmails());
    }

    /**
     * Извлекает почту
     * @param emailId
     * @return
     */
    @Override
    @Transactional
    public Email getEmail(Integer emailId) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Извлекаем существующую почту
        Email email = session.get(Email.class, emailId);

        // Возвращаем
        return email;
    }

    /**
     * Редактирование существующей записи о почте
     * @param email
     */
    @Override
    @Transactional
    public void editEmail(Email email) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Извлечение существующей почты по Id
        Email existingEmail = session.get(Email.class, email.getEmailId());
        // Обновление имени существующей почты
        existingEmail.setEmail(email.getEmail());
        // Сохранение изменений
        session.save(existingEmail);
    }

    /**
     * Удалить почту с указанным идентификатором
     * @param emailId
     */
    @Override
    @Transactional
    public void deleteEmail(Integer emailId) {
        // Получаем сессию от Hibernate
        Session session = sessionFactory.getCurrentSession();

        Email forDeleteEmail = session.get(Email.class, emailId);

        session.delete(forDeleteEmail);
    }

    /**
     * Удалить все почты пользователя
     * @param userId
     */
    @Override
    @Transactional
    public void deleteAllEmailsByUser(Integer userId) {
        Session session = sessionFactory.getCurrentSession();

        @SuppressWarnings("unchecked")
        List<Email> emails = (List<Email>) session.createQuery("FROM Email as e " +
                                                 "WHERE e.user.id = " + userId).list();

        for(Email email : emails) {
            session.delete(email);
        }
    }
}
