package com.alexfade.projects.contacts.model;

import javax.persistence.*;

/**
 * Created by Alexander Kovalevsky on 20.08.15.
 * Project name: ContactsProject
 */

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "phone_user_id_FK")
    private User user;

    public Phone() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Phone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
