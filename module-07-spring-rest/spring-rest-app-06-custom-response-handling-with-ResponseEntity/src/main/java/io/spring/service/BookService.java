package io.spring.service;

import io.spring.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book("1", "1984", "George Orwell"));
        books.add(new Book("2", "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
