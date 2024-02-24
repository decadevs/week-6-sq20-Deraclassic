package com.dera.services;

import com.dera.entities.Person;
import com.dera.enums.Role;
import com.dera.services.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        // Arrange
        library = new Library(); // Assuming your Library constructor can handle a null strategy for simplicity.
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
        assertNotNull(library.getBooks().get(title), "Book should exist in the library after being added.");
        assertEquals(copies, library.getBooks().get(title).getCopies(), "The number of copies should match the amount added.");
    }
    @Test
    void testBorrowBook() {
        // Arrange
        library.addBook("1984", 2);
        Person person = new Person("John Doe", Role.SENIOR_STUDENT);
        // Act
        String result = library.borrowBook(person, "1984");
        // Assert
        assertTrue(result.contains("has successfully borrowed") || result.contains("has been added to the queue"));
        assertEquals(1, library.getBooks().get("1984").getCopies(), "After borrowing, one copy should be left.");
    }

    @Test
    void testReturnBook() {
        // Arrange
        library.addBook("Brave New World", 1);
        Person person = new Person("Alice", Role.JUNIOR_STUDENT);
        library.borrowBook(person, "Brave New World"); // Assume this borrow is successful
        // Act
        String returnResult = library.returnBook("Brave New World");
        // Assert
        assertTrue(returnResult.contains("has been returned to the library"));
        assertEquals(1, library.getBooks().get("Brave New World").getCopies(), "After return, there should be 1 copy available.");
    }
}
