package com.dera.services;

import com.dera.entities.Book;
import com.dera.entities.BorrowRequest;
import com.dera.entities.Person;
import com.dera.enums.Role;

import java.util.*;

public class Library {
    private Role role;

    public Role getRole() {
        return role;
    }

    private Map<String, Book> books;

    public Map<String, Book> getBooks() {
        return books;
    }

    private PriorityQueue<BorrowRequest> borrowRequests = new PriorityQueue<>(Comparator.comparingInt(o -> o.getPerson().getRole().getPriority()));

    public String addBook(String title, int copies) {
        books = new HashMap<>();
        Book book = books.get(title);
        if (book == null) {
            book = new Book(title, copies);
            books.put(title, book);
            System.out.println(copies + " copies of" + title + " added to library");
            System.out.println();
        } else {
            book.setCopies(book.getCopies() + copies);
        }
        return "Book added";
    }
    public String borrowBook(Person person, String title) {
        Book book = books.get(title);
        BorrowRequest request = new BorrowRequest(person, title);
        borrowRequests.offer(request);

        // Process the queue after adding the new request
        processBorrowRequests();
        if (book.getCopies() == 0) {
            System.out.println(person.getRole()+ " " +person.getName() + " has been added to the queue for " + title + ".");
            return "Book taken.";
        }
        return person.getName() + " has been added to the queue for " + title + ".";

    }
    private void processBorrowRequests() {

        while (!borrowRequests.isEmpty()) {
            BorrowRequest request = borrowRequests.peek();
            Book book = books.get(request.getTitle());

            if (book != null && book.getCopies() > 0) {
                book.setCopies(book.getCopies() - 1);
                borrowRequests.poll();
                System.out.println(request.getPerson().getRole() +" " +request.getPerson().getName() + " has successfully borrowed " + request.getTitle() + ".");

            } else {

                break;
            }
            if(book.getCopies()==0){
                System.out.println();
                System.out.println("All copies of this book has been taken");
                System.out.println();
            }
        }
    }
    public String returnBook(String title) {
        Book book = books.get(title);
        if (book == null) {
            return "Book not from this Library.";
        }
        book.setCopies(book.getCopies() + 1);
        processBorrowRequests();
        System.out.println(book.getCopies() + " copies of " + title + " has been returned to the library.");
        System.out.println();
        return title + " has been returned to the library.";
    }

    @Override
    public String toString() {
        return "Library{" +
                "role=" + role +
                ", books=" + books +
                ", borrowRequests=" + borrowRequests +
                '}';
    }
}

