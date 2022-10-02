package com.example.demo.cabApplication.services;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.User;
import com.example.demo.cabApplication.repositories.IDriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("DriverOnboardingServiceTest")
@ExtendWith(MockitoExtension.class)
class DriverOnboardingServiceTest {
    @Mock
    private IDriverRepository driverRepositoryMock;

    @InjectMocks
    private DriverOnboardingService driverOnboardingService;


    @Test
    @DisplayName("create method should create Driver")
    void createDriver() {
        Driver expectedDriver = new Driver("1","Driver1", Gender.M,28,null,null,true);
        when(driverRepositoryMock.save(any(Driver.class))).thenReturn(expectedDriver);

        Driver actualDriver = driverOnboardingService.createDriver("Driver1", Gender.M,28,null,null,true);
        Assertions.assertEquals(expectedDriver,actualDriver);
        verify(driverRepositoryMock,times(1)).save(any(Driver.class));
    }
}