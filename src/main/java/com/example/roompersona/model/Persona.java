package com.example.roompersona.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "persona")
public class Persona {
    @PrimaryKey
    @NonNull
    String id;
    String name;
    String surname;
    int age;
    String mail;

    public Persona() {
        id = UUID.randomUUID().toString();
    }

    public Persona(String name, String surname, int age, String mail) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mail = mail;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
