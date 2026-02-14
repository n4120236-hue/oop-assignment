Restaurant Ordering System
SOLID Documentation
Single Responsibility Principle (SRP)
Each class has a single responsibility.
RestaurantController handles user interaction.
MenuService contains business logic and validation.
MenuItemRepository works only with the database.
Open-Closed Principle (OCP)
The system is open for extension through the abstract class MenuItem.
New menu item types (for example, Dessert) can be added without modifying existing service or controller code.
Liskov Substitution Principle (LSP)
The classes Dish and Drink are полноценные subclasses of MenuItem.
The program works correctly when the base type MenuItem is replaced with any of its subclasses.
Interface Segregation Principle (ISP)
Instead of one large interface, smaller specialized interfaces are used: Searchable and Validatable.
This allows classes to implement only the methods they actually need.
Dependency Inversion Principle (DIP)
High-level modules (Service and Controller) depend on abstractions (CrudRepository and Validatable) rather than concrete implementations.
Dependencies are injected through constructors.
Advanced OOP Features
Generics
The CrudRepository interface uses a generic type T to work with any entity type in the database.
Lambdas
Lambda expressions are used in MenuService to sort dishes by price and to filter objects.
Reflection
The ReflectionUtils class performs runtime inspection of MenuItem objects.
It retrieves class names, fields, and methods during program execution.
Interface Methods
The Validatable interface contains:
A default method to display validation status
A static method to check for null values
OOP Structure
Abstract Class and Subclasses
MenuItem is a base abstract class with fields id, name, and price.
Dish and Drink extend it and override the methods getCategory() and calculateDiscount().
Composition
MenuItem is associated with a category via a foreign key in the database and a corresponding field in the code, demonstrating composition.
Database Section
Schema
The categories table stores dish categories.
The menu_items table contains main data and is linked to categories through the foreign key category_id.
Sample Inserts
INSERT INTO categories (name) VALUES ('Main Course');

INSERT INTO menu_items (id, name, price, category_id) 
VALUES (1, 'Steak', 25.50, 1);
