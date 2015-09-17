package com.alexfade.projects.contacts.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexander Kovalevsky on 24.08.15.
 * Project name: ContactsProject
 */

@Entity
@Table(name = "PHONES")
public class Phone implements Serializable{

    private Integer phoneId;
    private String phone;
    private User user;

    public Phone() {

    }

    public Phone(String phone, User user) {
        this.phone = phone;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHONE_ID")
    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn(name = "PHONE_USER_ID_FK")
    public User getUser() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }
}
