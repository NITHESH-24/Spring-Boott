package com.example.todoapp.controller;

import com.example.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ToDoController {

    @Autowired
    private  ToDoService service;

    @PostMapping("/create")
    public String createTask(@RequestParam String title){
        return service.createTask(title);
    }

    @GetMapping("/tasks")
    public List<Map<String, Object>> getTasks(){
        return service.getAllTasks();
    }

    @PutMapping("/{id}")
    public String updateStage(@PathVariable long id, @RequestParam String stage){
        return service.updateStage(id, stage);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id){
        return service.deleteTask(id);



    }





}
