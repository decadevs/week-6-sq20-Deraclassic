//import com.dera.services.impl.LibraryServiceImpl;
//import com.dera.model.User;
//import com.dera.enums.UserRole;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class LibraryTest {
//    private LibraryServiceImpl library;
//    @BeforeEach
//    void setUp() {
//        // Arrange
//        library = new LibraryServiceImpl();
//    }
//
//    @Test
//    void addBookTest() {
//        // Arrange
//        String title = "The Great Gatsby";
//        int initialCopies = 3;
//        int additionalCopies = 2;
//        // Act
//        library.addBook(title, initialCopies); // First addition
//        library.addBook(title, additionalCopies); // Additional copies
//    }
//    @Test
//        void borrowBookTest() {
//       // Arrange
//        library.addBook("1984", 2);
//        User user = new User("John Doe", UserRole.SENIOR_STUDENT);
//        // Act
//       // library.borrowBook(user, "1984");
//        // Assert
//        //assertTrue(result.contains("has successfully borrowed") || result.contains("has been added to the queue"));
//
//    }
//}
//package com.dera.services;

import com.dera.enums.UserRole;
import com.dera.model.User;
import com.dera.services.LibraryService;
import com.dera.services.impl.LibraryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {

    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryServiceImpl();
    }

    @Test
    void addNewBook() {
        String result = libraryService.addBook("The Great Gatsby", 3);
        assertEquals("Book added", result);
    }

    @Test
    void testBorrowBook() {
        libraryService.addBook("1984", 2);
        User user = new User("John Doe", UserRole.SENIOR_STUDENT);
        String result = libraryService.borrowBook(user, "1984");
        assertTrue(result.contains("has successfully borrowed"));
    }

    @Test
    void testReturnBook() {
        libraryService.addBook("Animal Farm", 1);
        User user = new User("Jane Doe", UserRole.TEACHER);
        libraryService.borrowBook(user, "Animal Farm");
        String result = libraryService.returnBook(user, "Animal Farm");
        assertTrue(result.contains("has been returned to the library"));
    }

    @Test
    void testDisplayQueueBeforeBorrowing() {
        User user = new User("John Doe", UserRole.TEACHER);
        assertDoesNotThrow(() -> libraryService.displayQueueBeforeBorrowing(Arrays.asList(user), "The Great Gatsby"));
    }
}
