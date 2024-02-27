package com.dera.services;

import com.dera.impl.LibrarianServiceImpl;
import com.dera.entities.User;
import com.dera.enums.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private LibrarianServiceImpl library;
    @BeforeEach
    void setUp() {
        // Arrange
        library = new LibrarianServiceImpl();
    }

    @Test
    void addBookTest() {
        // Arrange
        String title = "The Great Gatsby";
        int initialCopies = 3;
        int additionalCopies = 2;
        // Act
        library.addBook(title, initialCopies); // First addition
        library.addBook(title, additionalCopies); // Additional copies
    }
    @Test
        void borrowBookTest() {
       // Arrange
        library.addBook("1984", 2);
        User user = new User("John Doe", UserRole.SENIOR_STUDENT);
        // Act
        String result = library.borrowBook(user, "1984");
        // Assert
        assertTrue(result.contains("has successfully borrowed") || result.contains("has been added to the queue"));

    }
}
