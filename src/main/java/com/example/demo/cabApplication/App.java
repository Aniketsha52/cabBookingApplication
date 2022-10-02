package com.example.demo.cabApplication;

import com.example.demo.cabApplication.appConfig.ApplicationConfig;
import com.example.demo.cabApplication.commands.CommandInvoker;
import com.example.demo.cabApplication.exceptions.NoSuchCommandException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class App {
	public static void main(String[] args) {
			List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
				run(commandLineArgs);
		}
		public static void run(List<String> commandLineArgs) {
			ApplicationConfig applicationConfig = new ApplicationConfig();
			CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(commandLineArgs.get(0)));
				String line = reader.readLine();
				while (line != null) {
					List<String> tokens = Arrays.asList(line.split("\\s+"));
					commandInvoker.executeCommand(tokens.get(0),tokens);
					// read next line
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException | NoSuchCommandException e) {
				e.printStackTrace();
			}
	}
}
