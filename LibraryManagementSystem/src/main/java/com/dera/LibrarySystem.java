package com.dera;
import com.dera.entities.User;
import com.dera.enums.UserRole;
import com.dera.impl.LibrarianServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Data
@AllArgsConstructor
public class LibrarySystem {
    public static void main(String[] args) {
        LibrarianServiceImpl librarianServiceImpl = new LibrarianServiceImpl();
        librarianServiceImpl.addBook("The Great Gatsby", 4);
        List<User> user = new ArrayList<>(Arrays.asList(new User("Mr. Smith", UserRole.TEACHER),(new User("Jane Doe", UserRole.SENIOR_STUDENT)),(new User("Mr. Johnson", UserRole.TEACHER)),(new User("John Craig", UserRole.JUNIOR_STUDENT)),(new User("Eva Lopez", UserRole.JUNIOR_STUDENT)),(new User("Armory Smack", UserRole.SENIOR_STUDENT)),(new User("Arnold Bee", UserRole.JUNIOR_STUDENT)),(new User("Boyd Bold", UserRole.JUNIOR_STUDENT)),(new User("Mr. Darwin", UserRole.TEACHER)),(new User("Emma Rose", UserRole.JUNIOR_STUDENT)),(new User("Ismail Nook", UserRole.SENIOR_STUDENT))));
        user.sort(Comparator.comparingInt(p -> p.getRole().getPriority()));
        user.forEach(person -> librarianServiceImpl.borrowBook(person, "The Great Gatsby"));

    }
}