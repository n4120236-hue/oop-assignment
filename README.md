Restaurant Ordering System API
📌 Project Overview

This is a console-based Java application for managing a restaurant menu. The project demonstrates advanced OOP concepts, interaction with a relational database using JDBC, and robust exception handling.

🧬 OOP Principles Applied

The project follows core Object-Oriented Programming principles:

Encapsulation: All fields in model classes (e.g., MenuItem) are declared as private. Access is provided through public getters and setters to ensure data integrity.

Inheritance: An abstract base class MenuItem is used to define common properties, while specific types like FoodItem and DrinkItem extend it.

Abstraction: The MenuItem class contains abstract methods such as getCategory() and getDetails(), which must be implemented by subclasses.

Polymorphism: The application uses List<MenuItem> to handle different types of menu items uniformly, allowing dynamic method invocation at runtime.

Composition: (Optional depending on your code) Entities are linked to represent real-world relationships, such as an Order containing multiple MenuItems.

📊 Database Layer

The project uses PostgreSQL as the data store. The menu_items table is designed to store both common and type-specific data.

SQL Schema:

SQL
CREATE TABLE menu_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    type VARCHAR(50),
    extra_info VARCHAR(255)
);
🛠 Architecture

The code is organized into a multi-layer architecture for better maintainability:

Model: Data entities (MenuItem, FoodItem).

Repository: Data Access Object (DAO) layer using JDBC PreparedStatement.

Service: Business logic and validation rules.

Util: Database connection management.

Exception: Custom exception hierarchy for specialized error handling.

🚀 Setup and Run

Database Setup: Create a database named restaurant_db and run the SQL script provided above.

Configuration: Update the DatabaseConnection.java file with your PostgreSQL username and password.

Drivers: Ensure the PostgreSQL JDBC driver is added to your project dependencies.

Execution: Run the Main.java class to start the application.

📸 Screenshots

Note: Replace the placeholders below with actual screenshots from your project to get the full 20 points.

Application Execution:

Database State:

📝 Reflection

During this assignment, I learned how to bridge a Java application with a real-world database. The most challenging part was designing a flexible inheritance structure that maps well to a flat SQL table and managing the lifecycle of database connections to prevent memory leaks.
