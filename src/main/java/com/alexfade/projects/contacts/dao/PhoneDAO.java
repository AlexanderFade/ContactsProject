package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.Phone;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */
public interface PhoneDAO {

    void create(Phone phone);
    List<Phone> readAll();
    void update(Phone phone);
    void delete(Phone phone);

}
