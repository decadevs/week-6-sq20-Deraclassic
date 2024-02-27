//
//package com.dera.entities;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Librarian {
//    private Map<String, Book> books = new HashMap<>();
//    public Librarian() {
//    }
//
//    public String addBook(String title, int copies) {
//        Book book = books.get(title);
//        if (book == null) {
//            book = new Book(title, 0);
//            books.put(title, book);
//        }
//        book.setCopies(book.getCopies() + copies);
//        books.put(title, book);
//        System.out.println(copies + " copies of " + title + " added to library");
//        return "Book added";
//    }
//    public String borrowBook(Person person, String title) {
//        Book book = books.get(title);
//        if (book == null) {
//            return "Book not part of our Catalogue.";
//        }
//        if (book.getCopies() > 0) {
//            book.setCopies(book.getCopies() - 1);
//            System.out.println(person.getRole() + " " + person.getName() + " has successfully borrowed " + title + ".");
//            return person.getName() + " has successfully borrowed " + title + ".";
//        } else {
//            System.out.println(person.getRole() + " " + person.getName() + " has been added to the queue ");
//            return "Book taken.";
//        }
//    }
//}

package com.dera.entities;

import java.util.HashMap;
import java.util.Map;

public class Librarian {
    private Map<String, Integer> bookCopies = new HashMap<>();

    public Librarian() {
    }

    public void addBook(String title, int copies) {
        bookCopies.merge(title, copies, Integer::sum);
        System.out.println(copies + " copies of " + title + " added to library");
    }

    public String borrowBook(Person person, String title) {
        Integer copies = bookCopies.get(title);
        if (copies == null || copies <= 0) {
            System.out.println(person.getRole() + " " + person.getName() + " cannot borrow " + title + " as it is not available.");
            return "Book not part of our Catalogue or all copies taken.";
        } else {
            bookCopies.put(title, copies - 1);
            System.out.println(person.getRole() + " " + person.getName() + " has successfully borrowed " + title + ".");
            return person.getName() + " has successfully borrowed " + title + ".";
        }
    }

    // Optionally, implement a returnBook method similar to borrowBook but in reverse.
}
