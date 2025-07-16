package com.example.todoapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToDoService {
    private  long taskId = 1;
    private final Map<Long, Map<String, Object>> tasks = new HashMap<>();


    public String createTask(String title){
        Map<String, Object> task = new HashMap<>();
        task.put("Title", title);
        task.put("Stage",  "Yet to start");
        task.put("Id", taskId);

        tasks.put(taskId, task);

        return "Task created successfully";
    }


    public List<Map<String, Object>> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public String updateStage(long taskId, String stage){
        Map<String, Object> task = tasks.get(taskId);
        if(task != null){
            task.put("Stage", stage);
            return "Stage updatged";
        }
        return "error";
    }

    public String deleteTask(long taskId){
        tasks.remove(taskId);
        return "Deleted successfully";
    }
}
