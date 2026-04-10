package com.example.demo.service;
import com.example.demo.exceptions.FindByIdRuntimeException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Trainee;
import com.example.demo.repositories.ITraineeRepo;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;
import com.example.demo.exceptions.FindByIdRuntimeException;

@Service
public class ITraineeServiceImpl implements ITraineeService {

	@Autowired
	private ITraineeRepo repo;

	@Override
	public List<Trainee> getAllTrainees() {
		return repo.findAll();
	}

	@Override
	public Trainee getTraineeById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new FindByIdRuntimeException("Trainee not found with id: " + id));
	}

	@Override
	public List<Trainee> getTraineeByName(String name) {
		return repo.findByTraineeName(name);
	}

	@Override
	public Trainee addTrainee(Trainee Trainee) {
		return repo.save(Trainee);
	}

	@Override
	public Trainee updateTrainee(int id, Trainee Trainee) {
		Trainee existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Trainee not found"));

		existing.setTraineeName(Trainee.getTraineeName());
		existing.setTraineeDomain(Trainee.getTraineeDomain());
		existing.setTraineeLocation(Trainee.getTraineeLocation());

		return repo.save(existing);
	}

	@Override
	public void deleteTrainee(int id) {
		repo.deleteById(id);
	}
}