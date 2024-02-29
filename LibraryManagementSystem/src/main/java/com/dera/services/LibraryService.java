package com.dera.services;

import com.dera.model.User;

import java.util.List;

public interface LibraryService {
    String addBook(String title, int copies);
    String borrowBook(User user, String title);
    String borrowBookFIFO(User user, String title);
    String returnBook(User user, String title);
    void displayQueueBeforeBorrowing(List<User> users, String title);
    void displayAllBorrowersForTitle(String title);
    void borrowBooksForUsers(List<User> users, String title);
}
