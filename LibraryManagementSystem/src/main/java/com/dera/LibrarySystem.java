package com.dera;

import com.dera.entities.Person;
import com.dera.enums.LibraryUserRole;
import com.dera.utils.PersonComparator;
import com.dera.entities.Librarian;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibrarySystem {
    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        librarian.addBook("The Great Gatsby", 4);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Mr. Smith", LibraryUserRole.TEACHER));
        people.add(new Person("Jane Doe", LibraryUserRole.SENIOR_STUDENT));
        people.add(new Person("Mr. Johnson", LibraryUserRole.TEACHER));
        people.add(new Person("John Craig", LibraryUserRole.JUNIOR_STUDENT));
        people.add(new Person("Eva Lopez", LibraryUserRole.JUNIOR_STUDENT));
        people.add(new Person("Armory Smack", LibraryUserRole.SENIOR_STUDENT));
        people.add(new Person("Arnold Bee", LibraryUserRole.JUNIOR_STUDENT));
        people.add(new Person("Boyd Bold", LibraryUserRole.JUNIOR_STUDENT));
        people.add(new Person("Mr. Darwin", LibraryUserRole.TEACHER));
        people.add(new Person("Emma Rose", LibraryUserRole.JUNIOR_STUDENT));
        people.add(new Person("Ismail Nook", LibraryUserRole.SENIOR_STUDENT));

        Collections.sort(people, new PersonComparator());
        for (Person person : people) {
            librarian.borrowBook(person, "The Great Gatsby");
        }
//        Collections.sort(people,(s1,s2) ->s1.getRole().compareTo(s2.getRole()));
//        people.forEach(
//                (n) -> System.out.println(n)
//        );
    }
}

//Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
//        students.forEach(
//                (n) -> System.out.println(n)
//        );
