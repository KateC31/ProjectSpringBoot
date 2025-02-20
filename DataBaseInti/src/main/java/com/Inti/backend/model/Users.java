package com.Inti.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_user;
    private String name;
    private String email;
    private Long phone;
    private String password;

    public Users(Long id_User, String name, String email, Long phone, String password) {
        this.id_user = id_User;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
