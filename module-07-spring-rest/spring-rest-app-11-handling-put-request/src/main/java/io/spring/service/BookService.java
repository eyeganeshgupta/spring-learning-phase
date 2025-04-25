package io.spring.service;

import io.spring.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final Map<Long, Book> bookMap = new HashMap<>();

    public BookService() {
        bookMap.put(1L, new Book(1L, "The Hobbit", "J.R.R. Tolkien"));
        bookMap.put(2L, new Book(2L, "1984", "George Orwell"));
        bookMap.put(3L, new Book(3L, "To Kill a Mockingbird", "Harper Lee"));
    }

    public void addBook(Book book) {
        bookMap.put(book.getId(), book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }
}
