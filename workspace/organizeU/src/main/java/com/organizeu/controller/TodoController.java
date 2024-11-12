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
                "🎉 Success! Your Todo item has been created and is now ready for action! 🎉",
                savedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<TodoDTO>> getTodo(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.getTodo(id);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "🔍 Here it is! Your requested Todo item has been retrieved successfully. Feel free to view or edit the details! 🔍",
                todoDTO
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CustomResponse<List<TodoDTO>>> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        CustomResponse<List<TodoDTO>> response = new CustomResponse<>(
                true,
                "📜 All Set! We've successfully gathered all your Todo items. Check out your complete list below! 📜",
                todos
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<TodoDTO>> updateTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id) {
        TodoDTO updatedTodo = todoService.updateTodo(todoDTO, id);
        CustomResponse<TodoDTO> response = new CustomResponse<>(
                true,
                "✏️ Updated! Your Todo item has been successfully modified. Review the changes made! ✏️",
                updatedTodo
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<CustomResponse<String>> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        CustomResponse<String> response = new CustomResponse<>(
                true,
                "Deleted! Your Todo item has been successfully deleted.",
                "Deleted!"
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
