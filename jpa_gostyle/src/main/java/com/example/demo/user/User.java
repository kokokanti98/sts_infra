package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String login;
    String password;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
