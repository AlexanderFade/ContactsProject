package com.alexfade.projects.contacts.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexander Kovalevsky on 24.08.15.
 * Project name: ContactsProject
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable{

    private Integer userId;
    private String login;
    private String first_name;
    private String second_name;

    private List<Email> emails;

    private List<Phone> phones;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //@Column(name = "LOGIN", unique = true, nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //@Column(name = "FIRST_NAME")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    //@Column(name = "SECOND_NAME")
    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
