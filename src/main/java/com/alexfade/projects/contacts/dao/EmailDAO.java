package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.Email;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */
public interface EmailDAO {

    void create(Email email);
    List<Email> readAll();
    void update(Email email);
    void delete(Email email);

}
