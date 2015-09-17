package com.alexfade.projects.contacts.dao;

import com.alexfade.projects.contacts.domain.User;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 27.08.15.
 * Project name: ContactsProject
 */
public interface UserDAO {

    void createUser(User user);
    List<User> readAll();
    void editUser(User user);
    void delete(User user);
    void deleteById(Integer user_id);
    User getUser(Integer userId);

}
