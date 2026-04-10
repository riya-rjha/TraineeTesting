package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entities.Trainee;
import com.example.demo.exceptions.FindByIdRuntimeException; 
import com.example.demo.repositories.ITraineeRepo;
import com.example.demo.service.ITraineeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

    @Mock
    private ITraineeRepo repo;

    @InjectMocks
    private ITraineeServiceImpl itservice;

    private Trainee trainee;

    @BeforeEach
    void setup() {
        trainee = new Trainee();
        trainee.setTraineeId(1);
        trainee.setTraineeName("Sarthak Sharma");
        trainee.setTraineeDomain("MERN");
        trainee.setTraineeLocation("Delhi");
    }

    @Test
    void testGetTraineeById() {

        when(repo.findById(1)).thenReturn(Optional.of(trainee));

        Trainee result = itservice.getTraineeById(1);

        assertEquals("Sarthak Sharma", result.getTraineeName());
//        assertEquals("Wrong Name", result.getTraineeName());
    }

    @Test
    void testGetTraineeById_NotFound() {

        when(repo.findById(1)).thenReturn(Optional.empty());

        assertThrows(FindByIdRuntimeException.class, () -> {
            itservice.getTraineeById(1);
        });
    }

    @Test
    void testAddTrainee() {

        when(repo.save(trainee)).thenReturn(trainee);

        Trainee result = itservice.addTrainee(trainee);

        assertNotNull(result);
        verify(repo).save(trainee);
    }

    @Test
    void testDeleteTrainee() {

        doNothing().when(repo).deleteById(1);

        itservice.deleteTrainee(1);

        verify(repo, times(1)).deleteById(1);
    }
}