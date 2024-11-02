package com.clearvoyage.shipping_estimator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Component
public class DatabaseConnectionTester implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        // Capture System outputs
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        // Redirect System.out and System.err to capture output
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        try {
            // Perform a simple query to check the connection
            entityManager.createNativeQuery("SELECT 1").getSingleResult();
            System.out.println("Database connection successful !");
        } catch (Exception e) {
            System.err.println("Database connection failed : " + e.getMessage());
        } finally {
            // Reset System.out and System.err
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        // Capture the output as strings
        String output = outContent.toString();
        String errorOutput = errContent.toString(); // Use errContent to capture error output

        // Optionally, you can log or process the captured output
        System.out.println("Captured Output: " + output);
        System.err.println("Captured Error Output: " + errorOutput);
    }
}
