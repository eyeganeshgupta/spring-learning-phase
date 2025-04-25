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

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Book>> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        ApiResponse<Book> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Book added successfully");
        response.setData(book);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        ApiResponse<List<Book>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Books retrieved successfully");
        response.setData(books);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        boolean isUpdated = bookService.updateBook(id, updatedBook);

        ApiResponse<Book> response = new ApiResponse<>();
        if (isUpdated) {
            response.setSuccess(true);
            response.setMessage("Book updated successfully");
            response.setData(updatedBook);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setSuccess(false);
            response.setMessage("Book not found with id: " + id);
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
