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
    public ResponseEntity<CustomResponse<TodoDTO>> addTodo(@Valid @RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodo = todoService.addTodo(todoDTO);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "Todo item has been created successfully.",
                savedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<TodoDTO>> getTodo(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.getTodo(id);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "Todo item retrieved successfully.",
                todoDTO
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CustomResponse<List<TodoDTO>>> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        CustomResponse<List<TodoDTO>> response = new CustomResponse<>(
                true,
                "Retrieved all Todo items successfully.",
                todos
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
