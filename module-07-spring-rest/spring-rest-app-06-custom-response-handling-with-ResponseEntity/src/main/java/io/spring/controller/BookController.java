package io.spring.controller;

import io.spring.model.Book;
import io.spring.response.ApiResponse;
import io.spring.service.BookService;
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
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        ApiResponse<List<Book>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Books retrieved successfully");
        response.setData(books);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        ApiResponse<Book> response = new ApiResponse<>();

        if (book == null) {
            response.setSuccess(false);
            response.setMessage("Book not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.setSuccess(true);
        response.setMessage("Book retrieved successfully");
        response.setData(book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        ApiResponse<String> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Book added successfully");
        response.setData(null);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
