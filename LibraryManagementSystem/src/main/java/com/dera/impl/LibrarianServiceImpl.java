
package com.dera.impl;

import com.dera.entities.User;
import com.dera.services.LibrarianService;

import java.util.HashMap;
import java.util.Map;

public class LibrarianServiceImpl implements LibrarianService{
    private Map<String, Integer> bookCopies = new HashMap<>();
    @Override
    public void addBook() {
    }

    @Override
    public void borrowBook() {
    }


    public void addBook(String title, int copies) {
        bookCopies.merge(title, copies, Integer::sum);
        System.out.println(copies + " copies of " + title + " added to library");
    }

    public String borrowBook(User user, String title) {
        Integer copies = bookCopies.get(title);
        if (copies == null || copies <= 0) {
            System.out.println(user.getRole() + " " + user.getName() + " cannot borrow " + title + " as it is not available.");
            return "Book not part of our Catalogue or all copies taken.";
        } else {
            bookCopies.put(title, copies - 1);
            System.out.println(user.getRole() + " " + user.getName() + " has successfully borrowed " + title + ".");
            return user.getName() + " has successfully borrowed " + title + ".";
        }
    }

    // Optionally, implement a returnBook method similar to borrowBook but in reverse.
}
