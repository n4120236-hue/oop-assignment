🍽️ Restaurant Ordering System (Milestone 2)
📌 Project Overview
This project is a refactored multi-layer Java API for a Restaurant Ordering System. It demonstrates the application of SOLID principles, Advanced Java features (Generics, Lambdas, Reflection), and Layered Architecture.

🛠️ Tech Stack
Language: Java 17+

Database: PostgreSQL

API Pattern: Controller-Service-Repository

Build Tool: Manual (or Maven/Gradle)

🧩 SOLID Principles Implementation
1. Single Responsibility Principle (SRP)

Each class has one reason to change:

MenuItemRepository: Only handles database operations (CRUD).

MenuService: Contains business logic and validation rules.

RestaurantController: Manages user interaction and flow control.

2. Open-Closed Principle (OCP)

The system is open for extension but closed for modification. We can add new types of menu items (e.g., Dessert, Combo) by extending the MenuItem abstract class without changing the existing MenuService or Repository logic.

3. Liskov Substitution Principle (LSP)

Subclasses Dish and Drink can be used interchangeably as MenuItem objects without breaking the application. All overridden methods like calculateTax() maintain the expected behavior of the base class.

4. Interface Segregation Principle (ISP)

Instead of one massive interface, we use focused interfaces:

Validatable<T>: For entity validation.

CrudRepository<T>: For data persistence.

5. Dependency Inversion Principle (DIP)

High-level modules (MenuService) do not depend on low-level modules (MenuItemRepository). Instead, they depend on abstractions (CrudRepository interface). This allows us to switch from PostgreSQL to any other database easily.

🚀 Advanced Features
Generics: The CrudRepository<T> interface uses generics to work with any entity type.

Lambda Expressions: Used in MenuService.getSortedMenu() to implement custom sorting logic: items.sort((a, b) -> Double.compare(a.getBasePrice(), b.getBasePrice()));

Reflection (RTTI): Implemented in ReflectionUtils to inspect class fields and methods at runtime.

Default/Static Methods: The Validatable interface includes a default method for logging and a static method for price checking.

📊 Database Schema
The project uses a relational structure in PostgreSQL:

menu_items: Stores all items with a type discriminator (DISH/DRINK).

Composition: Elements are linked through logical grouping in the service layer.

📁 Project Structure
Plaintext
src/
├── controller/     # Presentation Layer
├── service/        # Business Logic Layer (Validation, Sorting)
├── repository/     # Data Access Layer (PostgreSQL JDBC)
├── model/          # Entities (Abstract Base + Subclasses)
├── interfaces/     # Functional Interfaces & Contracts
├── exception/      # Custom Exception Hierarchy
└── utils/          # Reflection and DB Connection
📝 How to Run
Database Setup: Execute src/resources/schema.sql in your PostgreSQL terminal.

Configuration: Update DatabaseConnection.java with your PostgreSQL credentials.

Compile & Run: Run the Main.java file.
