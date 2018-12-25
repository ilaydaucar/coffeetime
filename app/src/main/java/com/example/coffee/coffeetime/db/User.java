package com.example.coffee.coffeetime.db;

import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class User {

    String userId;
    String name;
    String surname;
    int phoneNumber;
    String email;
    String password;

    public User() {
    }

    public User(String userId, String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

