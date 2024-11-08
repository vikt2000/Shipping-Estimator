# Shipping Estimator

This project is a Spring Boot application that provides an API for calculating shipping costs.

## Prerequisites

- Java 17 or higher
- Gradle
- Git

## Getting Started

### Clone the Repository

First, clone the repository to your local machine:

```sh
git clone https://github.com/vikt2000/Shipping-Estimator.git
cd Shipping-Estimator

Build the Project
Use Gradle to build the project:
./gradlew build

On Windows

gradlew.bat build

Run the Application 

To run the application, use the bootRun Gradle task:

./gradlew bootRun

On Windows

gradlew.bat bootRun

The application will start and be accessible at http://localhost:8080.

API Endpoints
Calculate Shipping Cost
URL: /api/shipping/calculate
Method: GET
Query Parameters:
departure (String): The departure location.
arrival (String): The arrival location.
vesselType (String): The type of vessel.
weight (double): The weight of the shipment.
