package com.example.demo.cabApplication.appConfig;

import com.example.demo.cabApplication.commands.AddDriverCommand;
import com.example.demo.cabApplication.commands.AddUserCommand;
import com.example.demo.cabApplication.commands.CommandInvoker;
import com.example.demo.cabApplication.commands.FindRideCommand;
import com.example.demo.cabApplication.repositories.DriverRepository;
import com.example.demo.cabApplication.repositories.IDriverRepository;
import com.example.demo.cabApplication.repositories.IUserRepository;
import com.example.demo.cabApplication.repositories.UserRepository;
import com.example.demo.cabApplication.services.DriverOnboardingService;
import com.example.demo.cabApplication.services.IDriverOnboardingService;
import com.example.demo.cabApplication.services.IUserOnboardingServices;
import com.example.demo.cabApplication.services.UserOnboardingServices;

public class ApplicationConfig {
    private final IUserRepository userRepository = new UserRepository();
    private final IDriverRepository driverRepository = new DriverRepository();

    private final IUserOnboardingServices userOnboardingServices = new UserOnboardingServices(userRepository,driverRepository);
    private final IDriverOnboardingService driverOnboardingService = new DriverOnboardingService(driverRepository);

    private final AddUserCommand addUserCommand = new AddUserCommand(userOnboardingServices);
    private final AddDriverCommand addDriverCommand = new AddDriverCommand(driverOnboardingService);
    private final FindRideCommand findRideCommand = new FindRideCommand(userOnboardingServices);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("add_user",addUserCommand);
        commandInvoker.register("add_driver", addDriverCommand);
        commandInvoker.register("find_ride",findRideCommand);

        return commandInvoker;
    }
}
