package com.organizeu.service.impl;

import com.organizeu.dto.TodoDTO;
import com.organizeu.entity.Todo;
import com.organizeu.repository.TodoRepository;
import com.organizeu.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {
        // convert TodoDTO into Todo JPA Entity
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.isCompleted());

        // Todo JPA Entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo JPA entity object into TodoDTO object
        TodoDTO savedTodoDTO = new TodoDTO();
        savedTodoDTO.setId(savedTodo.getId());
        savedTodoDTO.setTitle(savedTodo.getTitle());
        savedTodoDTO.setDescription(savedTodo.getDescription());
        savedTodoDTO.setCompleted(savedTodo.isCompleted());

        return savedTodoDTO;
    }
}
