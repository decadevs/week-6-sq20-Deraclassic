package com.dera.enums;

public enum UserRole {
    TEACHER(1),
    SENIOR_STUDENT(2),
    JUNIOR_STUDENT(3);

    private final int priority;

    UserRole(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
