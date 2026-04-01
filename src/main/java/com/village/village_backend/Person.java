package com.village.village_backend;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String category;

    private String surname;   // ⭐ VERY IMPORTANT (family grouping kosam)

    // 🔹 Default Constructor
    public Person() {
    }

    // 🔹 Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCategory() {
        return category;
    }

    public String getSurname() {
        return surname;
    }

    // 🔹 Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
