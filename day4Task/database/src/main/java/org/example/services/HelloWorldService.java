package org.example.services;

import org.example.models.Students;
import org.example.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    StudentRepository repo;

    public List<Students> getMethod() {
        return repo.findAll();
    }

    public List<Students> postMethod(Students todo) {
        repo.save(todo);
        return repo.findAll();
    }

    public String putMethod(int id, Students updatedTodo) {
        if (repo.existsById(id)) {
            updatedTodo.setId(id);
            repo.save(updatedTodo);
            return "Todo updated successfully!";
        } else {
            return "Todo with ID " + id + " not found!";
        }
    }

    public String deleteMethod(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Todo deleted successfully!";
        } else {
            return "Todo with ID " + id + " not found!";
        }
    }
}
