package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Trainee;

@Repository
public interface ITraineeRepo extends JpaRepository<Trainee, Integer> {

    @Query("SELECT t FROM Trainee t WHERE t.traineeName = :traineeName")
    List<Trainee> findByTraineeName(String traineeName);
}