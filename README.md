# Global Superstore: Spring Boot Application

## Introduction

Welcome to the Global Superstore project repository, an output of diligent learning from a comprehensive Spring Boot course. This application employs a combination of Thymeleaf for frontend representation and Spring Boot for backend operations, facilitating a seamless and fundamental learning curve for enthusiasts venturing into the world of Spring Boot. While the integration of frontend and backend within the same project might not reflect the latest trends in software design, it provides a straightforward approach to grasping the foundational concepts integral to Spring Boot development.

## Structure and Functionality 

Let us delve deeper into the core components of the application:

### 1. **StoreController (Controller Layer)**
   - Manages the handling of HTTP requests and responses, serving as the intermediary between the user interface and the service layer.
   - Utilizes methods from the `StoreService` class to access and manipulate data.

### 2. **StoreService (Service Layer)**
   - Implements the business logic, ensuring the seamless operation of the application.
   - Facilitates communication with the `StoreRepository` for CRUD operations and data management.

### 3. **StoreRepository (Repository Layer)**
   - Responsible for data storage and retrieval operations, functioning as the bridge between the service layer and the data entity.
   - Collaborates with the `Item` entity class to perform operations directly on the in-memory data storage.

### 4. **Item (Entity Layer)**
   - Represents the data model of an item in the inventory with fields such as category, name, price, discount, and date.
   - Includes validation constraints to maintain data integrity within the application.

## Deployment

To get started with the application, follow these steps:

### 1. **Environment Setup**
   - Ensure your development environment is equipped with the latest version of Spring Boot.
   - Clone the repository to your local system.

### 2. **Running the Application**
   - Navigate to the root directory of the project via the terminal.
   - Execute the command `mvn spring-boot:run` to initialize the application.

### 3. **Accessing the Application**
   - Once active, the application can be accessed at `http://localhost:8080`.

## Acknowledgments

This project signifies the culmination of a structured Spring Boot course, integrating the fundamentals of Spring Framework into a cohesive and functional application. The utilization of Thymeleaf for frontend development, while not aligning with contemporary code design paradigms, serves as a convenient platform for learning and consolidating knowledge on Spring Boot functionalities.

## Contribution

Contributors are encouraged to fork the project and submit pull requests or file issues to enhance the functionalities or report bugs. Your contributions are highly appreciated.

## License

The Global Superstore application is open-source, licensed under the [MIT License](LICENSE).

---

Thank you for visiting the Global Superstore project repository. Your contributions and feedback are welcome to foster the growth and refinement of this educational project.
