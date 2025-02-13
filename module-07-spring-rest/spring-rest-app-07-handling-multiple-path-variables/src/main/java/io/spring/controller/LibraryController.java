package io.spring.controller;

import io.spring.model.Book;
import io.spring.response.ApiResponse;
import io.spring.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{bookId}/authors/{authorId}")
    public ResponseEntity<ApiResponse<Book>> getBookAuthorDetails(
            @PathVariable String bookId,
            @PathVariable String authorId) {

        Book book = bookService.getBookById(bookId);

        String authorName = bookService.getAuthorById(authorId);

        ApiResponse<Book> response = new ApiResponse<>();

        if (book == null && authorName == null) {
            response.setSuccess(false);
            response.setMessage("Book and Author not found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if (book == null) {
            response.setSuccess(false);
            response.setMessage("Book not found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if (authorName == null) {
            response.setSuccess(false);
            response.setMessage("Author not found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        book.setAuthor(authorName);

        response.setSuccess(true);
        response.setMessage("Book and Author details retrieved successfully");
        response.setData(book);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
