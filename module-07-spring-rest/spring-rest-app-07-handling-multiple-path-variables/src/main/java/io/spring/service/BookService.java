package io.spring.service;

import io.spring.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book("1", "1984", null));
        books.add(new Book("2", "To Kill a Mockingbird", null));
        books.add(new Book("3", "The Great Gatsby", null));
    }

    public Book getBookById(String bookId) {
        return books.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    public String getAuthorById(String authorId) {
        switch (authorId) {
            case "101":
                return "George Orwell";
            case "102":
                return "Harper Lee";
            case "103":
                return "F. Scott Fitzgerald";
            default:
                return null;
        }
    }
}
