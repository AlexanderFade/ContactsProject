package com.alexfade.projects.contacts.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Alexander Kovalevsky on 20.08.15.
 * Project name: ContactsProject
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private int id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @OneToMany(mappedBy = "user")
    private Set<Phone> phones;

    @OneToMany(mappedBy = "user")
    private Set<Email> emails;

    public User(String login, String firstName, String secondName) {
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(String login, String firstName, String secondName, Set<Phone> phones, Set<Email> emails) {
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phones = phones;
        this.emails = emails;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
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

//    @OneToMany(targetEntity = Phone.class, cascade = CascadeType.ALL)
    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

//    @OneToMany(targetEntity = Email.class, cascade = CascadeType.ALL)
    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }
}
