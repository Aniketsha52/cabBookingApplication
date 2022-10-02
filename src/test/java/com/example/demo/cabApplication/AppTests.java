package com.example.demo.cabApplication;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest

class AppTests {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){
        List<String> arguments= new ArrayList<>(List.of("sampleTest/cabInput.txt"));
        String expectedOutput = "No ride found\r\nDriver1\r\n";
        App.run(arguments);
        Assertions.assertEquals(expectedOutput.trim(),outputStreamCaptor.toString().trim());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


}
