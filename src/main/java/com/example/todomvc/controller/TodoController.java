package com.example.todomvc.controller;

import com.example.todomvc.dao.TodoItemDao;
import com.example.todomvc.entity.TodoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoItemDao todoItemDao;
    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("item",new TodoItem());
        model.addAttribute("items",
                todoItemDao.findAll());
        return "index";
    }
    @PostMapping("/save-todo")
    public String saveTodoItem(TodoItem item, BindingResult result){
        if(result.hasErrors()){
            return "index";
        }
        todoItemDao.save(item);
        return "redirect:/";
    }


}
