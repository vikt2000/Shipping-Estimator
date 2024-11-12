Running Tests and Viewing Coverage Report
Prerequisites

    Java 17: Ensure you have Java 17 installed on your machine.
    VS Code Extension: Install the “Live Server” extension by Ritwick Dey in Visual Studio Code (only needed for viewing the coverage report).

Steps to Run Tests and Generate Coverage Report

    Open Terminal: Navigate to the root directory of your project.
    Run Tests and Generate Coverage Report:

    ./gradlew test jacocoTestReport

    Open Coverage Report (if you want to view it):
        Navigate to build/reports/jacoco/test/html.
        Right-click on the index.html file.
        Select “Open with Live Server”.

Running Tests Only

If you just want to run the tests without viewing the coverage report, you don’t need the Live Server extension. Simply run:

./gradlew test

This will execute all the tests in your project.