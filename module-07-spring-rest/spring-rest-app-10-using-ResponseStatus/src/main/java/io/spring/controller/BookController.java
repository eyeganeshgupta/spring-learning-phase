package io.spring.controller;

import io.spring.model.Book;
import io.spring.response.ApiResponse;
import io.spring.service.BookService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Book> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        ApiResponse<Book> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Book added successfully");
        response.setData(book);

        return response;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();

        ApiResponse<List<Book>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Books retrieved successfully");
        response.setData(books);

        return response;
    }
}

/**
 * NOTE:
 * While @ResponseStatus simplifies returning fixed HTTP status codes,
 * it has some limitations compared to using ResponseEntity:
 *
 * 1. Lack of Flexibility: We can't set custom headers or dynamically change the status code
 *    at runtime based on logic.
 *
 * 2. No Support for Conditional Responses: If the status needs to depend on the outcome
 *    (e.g., returning 404 if a book isn't found), ResponseEntity is preferred.
 *
 * 3. Reduced Readability in Some Cases: It might be harder for developers to track
 *    which status code is returned when working with larger or more dynamic APIs.
 *
 * ✅ Use @ResponseStatus for simple, predictable endpoints.
 * ✅ Use ResponseEntity when you need full control over the response.
 */
