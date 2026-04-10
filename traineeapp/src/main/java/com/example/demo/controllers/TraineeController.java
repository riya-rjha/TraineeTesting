package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.demo.entities.Trainee;
import com.example.demo.service.ITraineeService;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private ITraineeService service;

    // GET ALL
    @GetMapping("/employees")
    List<Trainee> fetchAllEmployees() {
        return service.getAllTrainees();
    }

    // GET BY ID
    @GetMapping("/employees/{id}")
    Trainee fetchEmployeesById(@PathVariable("id") int id) {
        return service.getTraineeById(id);
    }

    // INSERT (WITH VALIDATION)
    @PostMapping("/employees")
    Trainee insertEmployee(@Valid @RequestBody Trainee emp) {
        return service.addTrainee(emp);
    }

    // UPDATE
    @PutMapping("/employees/{id}")
    Trainee updateEmployee(@PathVariable int id, @Valid @RequestBody Trainee emp) {
        return service.updateTrainee(id, emp);
    }

    // DELETE
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable int id) {
        service.deleteTrainee(id);
    }
}