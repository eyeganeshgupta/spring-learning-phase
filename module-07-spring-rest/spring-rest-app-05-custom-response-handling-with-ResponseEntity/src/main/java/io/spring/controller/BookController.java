package io.spring.controller;

import io.spring.model.Book;
import io.spring.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookList");

        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
    }
}
