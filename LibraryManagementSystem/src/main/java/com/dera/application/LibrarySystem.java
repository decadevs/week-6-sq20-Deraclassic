package com.dera.application;

import com.dera.entities.Person;
import com.dera.enums.Role;
import com.dera.implementations.PersonComparator;
import com.dera.services.Library;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("The Great Gatsby", 4); // Adding 3 copies of "The Great Gatsby";

        List<Person> people = new ArrayList<>();
        people.add(new Person("Mr. Smith", Role.TEACHER));
        people.add(new Person("Jane Doe", Role.SENIOR_STUDENT));
        people.add(new Person("Mr. Johnson", Role.TEACHER));
        people.add(new Person("John Craig", Role.JUNIOR_STUDENT));
        people.add(new Person("Eva Lopez", Role.JUNIOR_STUDENT));
        people.add(new Person("Armory Smack", Role.SENIOR_STUDENT));
        people.add(new Person("Arnold Bee", Role.JUNIOR_STUDENT));
        people.add(new Person("Boyd Bold", Role.JUNIOR_STUDENT));
        people.add(new Person("Mr. Darwin", Role.TEACHER));
        people.add(new Person("Emma Rose", Role.JUNIOR_STUDENT));
        people.add(new Person("Ismail Nook", Role.SENIOR_STUDENT));

        Collections.sort(people, new PersonComparator());
        for (Person person : people) {
            library.borrowBook(person, "The Great Gatsby");
        }
    }
}

