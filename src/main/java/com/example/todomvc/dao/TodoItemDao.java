package com.example.todomvc.dao;

import com.example.todomvc.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemDao extends JpaRepository<TodoItem,Integer> {
}
