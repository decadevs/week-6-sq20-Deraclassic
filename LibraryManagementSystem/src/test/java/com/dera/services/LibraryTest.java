package com.dera.services;

import com.dera.entities.Librarian;
import com.dera.entities.Person;
import com.dera.enums.LibraryUserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Librarian library;

    @BeforeEach
    void setUp() {
        // Arrange
        library = new Librarian();
    }

    @Test
    void addNewBook() {
        // Arrange
        String title = "The Great Gatsby";
        int copies = 3;
        // Act
        String result = library.addBook(title, copies);
        // Assert
        assertEquals("Book added", result, "Book should be added to the library.");

    }
    @Test
    void testBorrowBook() {
        // Arrange
        library.addBook("1984", 2);
        Person person = new Person("John Doe", LibraryUserRole.SENIOR_STUDENT);
        // Act
        String result = library.borrowBook(person, "1984");
        // Assert
        assertTrue(result.contains("has successfully borrowed") || result.contains("has been added to the queue"));

    }


}
