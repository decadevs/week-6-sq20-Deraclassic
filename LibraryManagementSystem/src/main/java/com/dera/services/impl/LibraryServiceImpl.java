
package com.dera.services.impl;

import com.dera.model.Book;
import com.dera.model.User;
import com.dera.services.LibraryService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, List<User>> bookBorrowers = new HashMap<>();

    @Override
    public String addBook(String title, int copies) {
        books.merge(title, new Book(title, copies), (existingBook, newBook) -> {
            existingBook.setCopies(existingBook.getCopies() + newBook.getCopies());
            return existingBook;
        });
        System.out.println(copies+ " Books Added");
        return "Book added";
    }
    public void displayQueueBeforeBorrowing(List<User> users, String title) {
        System.out.println();
        System.out.println("Queue for borrowing '" + title + "':");
        users.forEach(user -> System.out.println(user.getRole() + " " + user.getName()));

    }
    public void displayAllBorrowersForTitle(String title) {
        if (!bookBorrowers.containsKey(title)) {
            System.out.println("No borrowers for " + title);
            return;
        }
        System.out.println("List of people who have borrowed " + title + ":");
        List<User> borrowers = bookBorrowers.get(title);
        borrowers.forEach(borrower -> System.out.println(borrower.getRole() + " " + borrower.getName() + " - " + title));
    }
    public void borrowBooksForUsers(List<User> users, String title) {
        users.forEach(user -> borrowBook(user, title));
    }
    @Override
    public String borrowBook(User user, String title) {

        try {
            Book book = books.get(title);
            if (book == null || book.getCopies() <= 0) {
                System.out.println(user.getRole() + " " + user.getName() + " cannot borrow " + title + " as it is not available.");
                return "Book not part of our Catalogue or all copies taken.";
            }
            synchronized (this) {
                book.setCopies(book.getCopies() - 1);
                bookBorrowers.computeIfAbsent(title, k -> new ArrayList<>()).add(user);
                bookBorrowers.get(title).sort(Comparator.comparingInt(u -> u.getRole().getPriority()));
            }
            return user.getRole() + " " + user.getName() + " has successfully borrowed " + title + ".";
        } catch (Exception e) {
            System.err.println("An error occurred while trying to borrow the book: " + e.getMessage());
            return "An error occurred during the borrowing process.";
        }
    }
    @Override
    public String returnBook(User user, String title) {
        if (user == null || title == null) {
            throw new IllegalArgumentException("User and title must not be null.");
        }
        Book book = books.get(title);
        if (book == null) {
            throw new IllegalArgumentException("Book not from this Library.");
            //return "Book not from this Library.";
        }
        book.setCopies(book.getCopies() + 1);
        return title + " has been returned to the library.";
    }
}
