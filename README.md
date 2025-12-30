# Vehicle Management System (Assignment 2)

## Project Overview
[cite_start]This project is a Vehicle Management System designed to demonstrate Object-Oriented Programming principles[cite: 11]. The system uses inheritance, composition, and abstraction to manage different types of vehicles. [cite_start]The main logic involves an abstract `Vehicle` class and specific subclasses like `Car`, `Motorcycle`, and `Truck`[cite: 12]. [cite_start]It also includes a `Driver` class to show how objects can be associated with each other[cite: 56].

## Class Hierarchy
The project is structured around the `Vehicle` abstract class:

* [cite_start]**Vehicle (Superclass):** Holds common fields like `brand`, `year`, and a `Driver` object[cite: 14]. [cite_start]It defines abstract methods `startEngine()` and `stopEngine()` that every vehicle must implement[cite: 23].
* **Car:** Extends Vehicle. [cite_start]Adds fields for `doors` and `fuelType`[cite: 29].
* **Motorcycle:** Extends Vehicle. [cite_start]Adds a `hasSidecar` field[cite: 38].
* **Truck:** Extends Vehicle. [cite_start]Adds fields for `capacity` and `numAxles`[cite: 46].
* **Driver:** Represents a person who drives the vehicle. [cite_start]This demonstrates composition (a vehicle has a driver)[cite: 66].

[cite_start]I used `protected` access modifiers in the parent class so that subclasses could easily access the brand and year, while keeping specific fields `private` for encapsulation[cite: 6].

## Instructions to Compile and Run
To compile and run the project, open your terminal in the folder containing the `.java` files and run:

```bash
javac *.java
java Main

Reflection
Inheritance significantly simplified the design because I didn't have to rewrite code for brand and year in every class.
I just put it in the parent Vehicle class, and all subclasses got it automatically.
Method overriding was very useful because it allowed me to customize how each vehicle starts and stops without changing the main logic loop.
A challenge I faced was working with access modifiers. Initially, I kept fields private in the superclass, but then the subclasses couldn't reach them.
Switching to protected solved this but I had to be careful not to expose too much data.
Connecting the Driver to the Vehicle also helped me understand how objects interact in memory
