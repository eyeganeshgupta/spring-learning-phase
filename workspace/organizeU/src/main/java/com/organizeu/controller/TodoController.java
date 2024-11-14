package com.organizeu.controller;

import com.organizeu.dto.TodoDTO;
import com.organizeu.response.CustomResponse;
import com.organizeu.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing To-Do items.
 * This class handles HTTP requests related to creating, retrieving, updating, and deleting To-Do items.
 * It also supports marking To-Do items as complete or incomplete.
 */
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@Validated
public class TodoController {

    // Injecting the TodoService to handle business logic for To-Do items.
    private final TodoService todoService;

    /**
     * Create a new To-Do item.
     * Only users with the 'ADMIN' role can access this endpoint.
     *
     * @param todoDTO The data transfer object representing the To-Do item to be created.
     * @return A ResponseEntity containing the created To-Do item and a success message.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CustomResponse<TodoDTO>> createTodo(@Valid @RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodo = todoService.createTodo(todoDTO);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "To-Do item created successfully.",
                savedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Retrieve a specific To-Do item by its ID.
     * Users with either 'ADMIN' or 'USER' roles can access this endpoint.
     *
     * @param id The ID of the To-Do item to retrieve.
     * @return A ResponseEntity containing the retrieved To-Do item and a success message.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<TodoDTO>> getTodoById(@PathVariable Long id) {
        TodoDTO todo = todoService.getTodoById(id);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "To-Do item retrieved successfully.",
                todo
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Retrieve all To-Do items.
     * Users with either 'ADMIN' or 'USER' roles can access this endpoint.
     *
     * @return A ResponseEntity containing the list of all To-Do items and a success message.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<CustomResponse<List<TodoDTO>>> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        CustomResponse<List<TodoDTO>> response = new CustomResponse<>(
                true,
                "All To-Do items retrieved successfully.",
                todos
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update an existing To-Do item by its ID.
     * Only users with the 'ADMIN' role can access this endpoint.
     *
     * @param id The ID of the To-Do item to update.
     * @param todoDTO The updated data for the To-Do item.
     * @return A ResponseEntity containing the updated To-Do item and a success message.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<TodoDTO>> updateTodoById(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        TodoDTO updatedTodo = todoService.updateTodoById(id, todoDTO);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "To-Do item updated successfully.",
                updatedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete a specific To-Do item by its ID.
     * Only users with the 'ADMIN' role can access this endpoint.
     *
     * @param id The ID of the To-Do item to delete.
     * @return A ResponseEntity containing a success message after deletion.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<String>> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        CustomResponse<String> response = new CustomResponse<>(
                true,
                "To-Do item deleted successfully.",
                "Deleted"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Mark a specific To-Do item as complete by its ID.
     * Users with either 'ADMIN' or 'USER' roles can access this endpoint.
     *
     * @param id The ID of the To-Do item to mark as complete.
     * @return A ResponseEntity containing the updated To-Do item and a success message.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/{id}/complete")
    public ResponseEntity<CustomResponse<TodoDTO>> markAsComplete(@PathVariable Long id) {
        TodoDTO updatedTodo = todoService.markTodoAsComplete(id);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "To-Do item marked as complete.",
                updatedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Mark a specific To-Do item as incomplete by its ID.
     * Users with either 'ADMIN' or 'USER' roles can access this endpoint.
     *
     * @param id The ID of the To-Do item to mark as incomplete.
     * @return A ResponseEntity containing the updated To-Do item and a success message.
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<CustomResponse<TodoDTO>> markAsIncomplete(@PathVariable Long id) {
        TodoDTO updatedTodo = todoService.markTodoAsIncomplete(id);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "To-Do item marked as incomplete.",
                updatedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
