package com.dera.entities;

import com.dera.enums.Role;

import java.util.Comparator;

public class Person {
    private String name;
    private Role role;

    public Person(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    // Getters and possibly setters
    public String getName() {
        return name;
    }

    public Role getRole() {
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
