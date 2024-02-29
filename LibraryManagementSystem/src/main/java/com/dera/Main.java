package com.dera;

import com.dera.enums.UserRole;
import com.dera.model.User;
import com.dera.services.impl.LibraryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryServiceImpl librarian = new LibraryServiceImpl();
        librarian.addBook("The Great Gatsby", 4);
        librarian.addBook("Gold Digger",2);

        List<User> people = new ArrayList<>();
        people.add(new User("Mr. Smith", UserRole.TEACHER));
        people.add(new User("Jane Doe", UserRole.SENIOR_STUDENT));
        people.add(new User("Mr. Johnson", UserRole.TEACHER));
        people.add(new User("John Craig", UserRole.JUNIOR_STUDENT));
        people.add(new User("Eva Lopez", UserRole.JUNIOR_STUDENT));
        people.add(new User("Armory Smack", UserRole.SENIOR_STUDENT));
        people.add(new User("Arnold Bee", UserRole.JUNIOR_STUDENT));
        people.add(new User("Boyd Bold", UserRole.JUNIOR_STUDENT));
        people.add(new User("Mr. Darwin", UserRole.TEACHER));
        people.add(new User("Emma Rose", UserRole.JUNIOR_STUDENT));
        people.add(new User("Ismail Nook", UserRole.SENIOR_STUDENT));

        librarian.displayQueueBeforeBorrowing(people, "The Great Gatsby");

        System.out.println();

        librarian.borrowBooksForUsers(people, "The Great Gatsby");

        System.out.println();

        librarian.displayAllBorrowersForTitle("The Great Gatsby");


    }
}
