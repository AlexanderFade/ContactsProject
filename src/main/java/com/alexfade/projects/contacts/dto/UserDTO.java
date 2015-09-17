package com.alexfade.projects.contacts.dto;

import com.alexfade.projects.contacts.domain.Email;
import com.alexfade.projects.contacts.domain.Phone;

import java.util.List;

/**
 * Created by Alexander Kovalevsky on 08.09.15.
 * Project name: ContactsProject
 */
public class UserDTO {

    private Integer userId;
    private String login;
    private String firstName;
    private String secondName;
    private List<Email> emails;
    private List<Phone> phones;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
