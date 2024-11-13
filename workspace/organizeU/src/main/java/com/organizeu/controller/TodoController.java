package com.organizeu.controller;

import com.organizeu.dto.TodoDTO;
import com.organizeu.response.CustomResponse;
import com.organizeu.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@Validated
public class TodoController {

    private final TodoService todoService;

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
