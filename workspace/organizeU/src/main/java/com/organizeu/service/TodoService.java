package com.organizeu.service;

import com.organizeu.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    TodoDTO createTodo(TodoDTO todoDTO);
    TodoDTO getTodoById(Long id);
    List<TodoDTO> getAllTodos();
    TodoDTO updateTodoById(Long id, TodoDTO todoDTO);
    void deleteTodoById(Long id);
    TodoDTO markTodoAsComplete(Long id);
    TodoDTO markTodoAsIncomplete(Long id);
}
