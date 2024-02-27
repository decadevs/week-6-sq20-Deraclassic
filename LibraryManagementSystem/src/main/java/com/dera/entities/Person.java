package com.dera.entities;

import com.dera.enums.LibraryUserRole;
public class Person {
    private String name;
    private LibraryUserRole role;


    public Person(String name, LibraryUserRole role) {
        this.name = name;
        this.role = role;
    }

    // Getters and possibly setters
    public String getName() {
        return name;
    }

    public LibraryUserRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
