package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.Phone;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */
public interface PhoneDAO {

    void createPhone(Phone phone);
    List<Phone> getAllPhones();
    List<Phone> getAllPhonesByUser(Integer userId);
    Phone getPhoneByUser(Integer userId);
    void updatePhone(Phone phone);
    void deletePhone(Integer phoneId);
    void deleteAllPhonesByUser(Integer userId);

}
