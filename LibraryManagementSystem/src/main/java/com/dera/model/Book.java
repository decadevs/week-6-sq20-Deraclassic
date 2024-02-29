package com.dera.model;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
public class Book{
    @Getter
    private String title;
    @Setter
    private int copies;

    public int getCopies() {
        return copies;
    }

    public Book(String title, int copies) {
        this.title = title;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", copies=" + copies +
                '}';
    }
}