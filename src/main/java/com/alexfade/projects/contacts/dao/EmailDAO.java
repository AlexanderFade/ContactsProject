package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.Email;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */
public interface EmailDAO {

    void createEmail(Integer userId, Email email);
    List<Email> getAllEmails();
    List<Email> getAllEmailsByUser(Integer userId);
    Email getEmail(Integer emailId);
    void editEmail(Email email);
    void deleteEmail(Integer emailId);
    void deleteAllEmailsByUser(Integer userId);

}
