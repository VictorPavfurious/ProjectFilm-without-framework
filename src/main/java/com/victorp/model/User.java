package com.victorp.model;

public class User {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String password;
    private String token;

    public User() {}

    public User(Long id, String name, String surName, String email, String password, String token) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public User(String name, String surName, String email, String password, String token) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return name + surName + email + password + token;
    }
}
