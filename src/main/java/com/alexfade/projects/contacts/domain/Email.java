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

    private Integer emailId;
    private String email;
    private User user;

    public Email() {

    }

    public Email(String email, User user) {
        this.email = email;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMAIL_ID")
    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

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
