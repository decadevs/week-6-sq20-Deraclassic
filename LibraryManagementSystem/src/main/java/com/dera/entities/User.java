package com.dera.entities;

import com.dera.enums.UserRole;
import lombok.Data;

@Data

public class User {
    private String name;
    private UserRole role;


    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }
}
