package com.example.demo.cabApplication.services;

import com.example.demo.cabApplication.entites.*;
import com.example.demo.cabApplication.exceptions.DriverNotFoundException;
import com.example.demo.cabApplication.repositories.IDriverRepository;
import com.example.demo.cabApplication.repositories.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("UserOnboardingServicesTest")
@ExtendWith(MockitoExtension.class)
class UserOnboardingServicesTest {
    @Mock
    private IUserRepository userRepositoryMock;
    @Mock
    private IDriverRepository driverRepositoryMock;
    @Mock
    private IUserOnboardingServices userOnboardingServicesMock;

    @InjectMocks
    private UserOnboardingServices userOnboardingServices;


    @Test
    @DisplayName("create method should create new user")
    void createUser() {
        User expectedUser = new User("1", "Aniket", Gender.M, 22);
        when(userRepositoryMock.save(any(User.class))).thenReturn(expectedUser);

        User actualUser = userOnboardingServices.createUser("Aniket", Gender.M, 22);
        Assertions.assertEquals(expectedUser, actualUser);
        verify(userRepositoryMock, times(1)).save(any(User.class));
    }
}

