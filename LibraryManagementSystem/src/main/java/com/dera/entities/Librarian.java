//package com.dera.entities;
//
//import com.dera.entities.Book;
//import com.dera.entities.Person;
//import com.dera.enums.Role;
//
//import java.util.*;
//
//public class Librarian {
//    public Role role;
//    private Map<String, Book> books;
//    private PriorityQueue<BorrowRequest> borrowRequests = new PriorityQueue<>();
//
//    public Role getRole() {
//        return role;
//    }
//
//    public Map<String, Book> getBooks() {
//        return books;
//    }
//
//    public String addBook(String title, int copies) {
//        books = new HashMap<>();
//        Book book = books.get(title);
//        if (book == null) {
//            book = new Book(title, copies);
//            books.put(title, book);
//            System.out.println(copies + " copies of" + title + " added to library");
//            System.out.println();
//        } else {
//            book.setCopies(book.getCopies() + copies);
//        }
//        return "Book added";
//    }
//
//    public String borrowBook(Person person, String title) {
//        Book book = books.get(title);
//        BorrowRequest request = new BorrowRequest(person, title);
//        borrowRequests.offer(request);
//
//        processBorrowRequests();
//        if (book.getCopies() == 0) {
//            System.out.println(person.getRole()+ " " +person.getName() + " has been added to the queue for " + title + ".");
//            return "Book taken.";
//        }
//        return person.getName() + " has been added to the queue for " + title + ".";
//
//    }
//    private void processBorrowRequests() {
//        while (!borrowRequests.isEmpty()) {
//            BorrowRequest request = borrowRequests.peek();
//            Book book = books.get(request.getTitle());
//            if (book != null && book.getCopies() > 0) {
//                book.setCopies(book.getCopies() - 1);
//                borrowRequests.poll();
//                System.out.println(request.getPerson().getRole() +" " +request.getPerson().getName() + " has successfully borrowed " + request.getTitle() + ".");
//            } else {
//                break;
//            }
//            if(book.getCopies()==0){
//                System.out.println();
//                System.out.println("All copies of this book has been taken");
//                System.out.println();
//            }
//        }
//    }
//
//
//    @Override
//    public String toString() {
//        return "Library{" +
//                "role=" + role +
//                ", books=" + books +
//                ", borrowRequests=" + borrowRequests +
//                '}';
//    }
//}
package com.dera.entities;

import com.dera.enums.LibraryUserRole;

import java.util.HashMap;
import java.util.Map;

public class Librarian {
    private LibraryUserRole role;
    private Map<String, Book> books = new HashMap<>();

    public Librarian() {
    }

    public LibraryUserRole getRole() {
        return role;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public String addBook(String title, int copies) {
        Book book = books.get(title);
        if (book == null) {
            book = new Book(title, 0);
            books.put(title, book);
        }
        book.setCopies(book.getCopies() + copies);
        books.put(title, book);
        System.out.println(copies + " copies of " + title + " added to library");
        return "Book added";
    }

    public String borrowBook(Person person, String title) {
        Book book = books.get(title);
        if (book == null) {
            return "Book not part of our Catalogue.";
        }
        if (book.getCopies() > 0) {
            book.setCopies(book.getCopies() - 1);
            System.out.println(person.getRole() + " " + person.getName() + " has successfully borrowed " + title + ".");
            return person.getName() + " has successfully borrowed " + title + ".";
        } else {
            System.out.println(person.getRole() + " " + person.getName() + " has been added to the queue ");
            return "Book taken.";
        }
    }

    public String returnBook(String title) {
        Book book = books.get(title);
        if (book == null) {
            return "Book not from this Library.";
        }
        book.setCopies(book.getCopies() + 1);
        System.out.println("A copy of " + title + " has been returned to the library.");
        return title + " has been returned to the library.";
    }
}


