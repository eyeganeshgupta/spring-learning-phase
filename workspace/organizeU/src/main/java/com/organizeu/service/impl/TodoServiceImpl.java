package com.organizeu.service.impl;

import com.organizeu.dto.TodoDTO;
import com.organizeu.entity.Todo;
import com.organizeu.exception.ResourceNotFoundException;
import com.organizeu.repository.TodoRepository;
import com.organizeu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    private static final String TODO_NOT_FOUND_MESSAGE = "Todo not found with ID: ";

    @Override
    @Transactional
    public TodoDTO createTodo(TodoDTO todoDTO) {
        Todo todo = convertToEntity(todoDTO);
        Todo savedTodo = todoRepository.save(todo);
        return convertToDTO(savedTodo);
    }

    @Override
    public TodoDTO getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TODO_NOT_FOUND_MESSAGE + id));
        return convertToDTO(todo);
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TodoDTO updateTodoById(Long id, TodoDTO todoDTO) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TODO_NOT_FOUND_MESSAGE + id));

        Optional.ofNullable(todoDTO.getTitle()).ifPresent(existingTodo::setTitle);
        Optional.ofNullable(todoDTO.getDescription()).ifPresent(existingTodo::setDescription);
        Optional.of(todoDTO.isCompleted()).ifPresent(existingTodo::setCompleted);

        Todo updatedTodo = todoRepository.save(existingTodo);
        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TODO_NOT_FOUND_MESSAGE + id));
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDTO markTodoAsComplete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TODO_NOT_FOUND_MESSAGE + id));
        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public TodoDTO markTodoAsIncomplete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TODO_NOT_FOUND_MESSAGE + id));
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    private TodoDTO convertToDTO(Todo todo) {
        return modelMapper.map(todo, TodoDTO.class);
    }

    private Todo convertToEntity(TodoDTO todoDTO) {
        return modelMapper.map(todoDTO, Todo.class);
    }
}
