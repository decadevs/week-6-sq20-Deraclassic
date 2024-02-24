package com.dera.entities;

import com.dera.enums.Role;

public class BorrowRequest implements Comparable<BorrowRequest> {
    private Person person;
    private String title;

    public BorrowRequest(Person person, String title) {
        this.person = person;
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BorrowRequest other) {
        // Assuming Role enum has an integer priority field or method
        return Integer.compare(this.person.getRole().getPriority(), other.getPerson().getRole().getPriority());
    }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "person=" + person +
                ", title='" + title + '\'' +
                '}';
    }
}
