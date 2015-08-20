package com.alexfade.projects.contacts;

import com.alexfade.projects.contacts.model.Email;
import com.alexfade.projects.contacts.model.Phone;
import com.alexfade.projects.contacts.model.User;
import com.alexfade.projects.contacts.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

/**
 * Created by Alexander Kovalevsky on 20.08.15.
 * Project name: ContactsProject
 */
public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        User user = new User();
        user.setLogin("AlexFade");
        session.save(user);

        Phone phone1 = new Phone("9688064196");
        Phone phone2 = new Phone("4951111111");

        Email email1 = new Email("alexanderfade@gmail.com");
        Email email2 = new Email("a.s.kovalevsky@gmail.com");

        phone1.setUser(user);
        phone2.setUser(user);

        email1.setUser(user);
        email2.setUser(user);

        session.save(phone1);
        session.save(phone2);
        session.save(email1);
        session.save(email2);

        session.getTransaction().commit();
        session.close();
    }
}
