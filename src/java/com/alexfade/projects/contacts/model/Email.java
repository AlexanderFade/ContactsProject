package com.alexfade.projects.contacts.model;

import javax.persistence.*;

/**
 * Created by Alexander Kovalevsky on 20.08.15.
 * Project name: ContactsProject
 */

@Entity
@Table(name = "email")
public class Email {

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "email_user_id_FK")
    private User user;

    public Email(String email) {
        this.email = email;
    }

    public Email() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
