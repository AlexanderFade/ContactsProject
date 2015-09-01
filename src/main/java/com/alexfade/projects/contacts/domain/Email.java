package com.alexfade.projects.contacts.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexander Kovalevsky on 24.08.15.
 * Project name: ContactsProject
 */

@Entity
@Table(name = "EMAILS")
public class Email implements Serializable{

    private String email;

    private User user;

    public Email() {

    }

    public Email(String email, User user) {
        this.email = email;
        this.user = user;
    }

    @Id
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "EMAIL_USER_ID_FK")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
