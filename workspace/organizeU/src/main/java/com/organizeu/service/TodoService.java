package com.organizeu.service;

import com.organizeu.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    TodoDTO addTodo(TodoDTO todoDTO);
    TodoDTO getTodo(Long id);
    List<TodoDTO> getAllTodos();
    TodoDTO updateTodo(TodoDTO todoDTO, Long id);
    void deleteTodo(Long id);
    TodoDTO completeTodo(Long id);
}
