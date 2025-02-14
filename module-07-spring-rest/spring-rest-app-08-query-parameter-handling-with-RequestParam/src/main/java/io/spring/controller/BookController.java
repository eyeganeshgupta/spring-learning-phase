package io.spring.controller;

import io.spring.model.Book;
import io.spring.response.ApiResponse;
import io.spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        Book book = bookService.searchBook(title, author);

        ApiResponse<Book> response = new ApiResponse<>();

        if (book == null) {
            response.setSuccess(false);
            response.setMessage("No book found matching the criteria");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.setSuccess(true);
        response.setMessage("Book found successfully");
        response.setData(book);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
