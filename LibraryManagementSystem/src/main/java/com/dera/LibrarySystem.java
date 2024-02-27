package com.dera;
import com.dera.entities.Person;
import com.dera.enums.LibraryUserRole;
import com.dera.entities.Librarian;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class LibrarySystem {
    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        librarian.addBook("The Great Gatsby", 4);
        List<Person> user = new ArrayList<>(Arrays.asList(new Person("Mr. Smith", LibraryUserRole.TEACHER),(new Person("Jane Doe", LibraryUserRole.SENIOR_STUDENT)),(new Person("Mr. Johnson", LibraryUserRole.TEACHER)),(new Person("John Craig", LibraryUserRole.JUNIOR_STUDENT)),(new Person("Eva Lopez", LibraryUserRole.JUNIOR_STUDENT)),(new Person("Armory Smack", LibraryUserRole.SENIOR_STUDENT)),(new Person("Arnold Bee", LibraryUserRole.JUNIOR_STUDENT)),(new Person("Boyd Bold", LibraryUserRole.JUNIOR_STUDENT)),(new Person("Mr. Darwin", LibraryUserRole.TEACHER)),(new Person("Emma Rose", LibraryUserRole.JUNIOR_STUDENT)),(new Person("Ismail Nook", LibraryUserRole.SENIOR_STUDENT))));
        user.sort(Comparator.comparingInt(p -> p.getRole().getPriority()));
        user.forEach(person -> librarian.borrowBook(person, "The Great Gatsby"));

    }
}