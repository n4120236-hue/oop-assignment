Проект Restaurant Ordering System
SOLID Documentation

Single Responsibility Principle SRP Каждый класс выполняет одну задачу. RestaurantController отвечает за взаимодействие с пользователем. MenuService содержит бизнес-логику и валидацию. MenuItemRepository работает только с базой данных.





Open-Closed Principle OCP Система открыта для расширения через абстрактный класс MenuItem. Можно добавлять новые типы позиций меню например Dessert без изменения существующего кода сервисов или контроллера.


Liskov Substitution Principle LSP Классы Dish и Drink являются полноценными подклассами MenuItem. Программа работает корректно при замене базового типа MenuItem на любой из его подклассов.





Interface Segregation Principle ISP Вместо одного большого интерфейса используются узкоспециализированные Searchable и Validatable. Это позволяет классам реализовывать только необходимые методы.




Dependency Inversion Principle DIP Высокоуровневые модули Service и Controller зависят от интерфейсов CrudRepository и Validatable а не от конкретных реализаций. Зависимости передаются через конструкторы.




Advanced OOP Features

Generics Интерфейс CrudRepository использует дженерик T для работы с любыми типами сущностей в базе данных.



Lambdas Лямбда-выражения используются в MenuService для сортировки списка блюд по цене и для фильтрации объектов.



Reflection Класс ReflectionUtils выполняет runtime проверку объектов MenuItem. Он извлекает названия классов поля и методы во время выполнения программы.




Interface Methods В интерфейсе Validatable реализован default метод для вывода статуса и static метод для проверки на null.



OOP Structure

Abstract Class and Subclasses MenuItem является базовым абстрактным классом с полями id name и price. Dish и Drink расширяют его и переопределяют методы getCategory и calculateDiscount.





Composition MenuItem связан с категорией через внешний ключ в базе данных и поле в коде что демонстрирует отношение композиции.



Database Section

Schema Таблица categories хранит типы блюд. Таблица menu_items содержит основные данные и связана с categories через foreign key category_id.



Sample Inserts INSERT INTO categories name VALUES Main Course. INSERT INTO menu_items id name price category_id VALUES 1 Steak 25.50 1.


Execution Instructions

Requirements Java 17 или выше. PostgreSQL Server. JDBC Driver для PostgreSQL в classpath проекта.

How to run Создать базу данных restaurant_db. Выполнить SQL скрипт из файла schema.sql. Скомпилировать файлы из папки src и запустить класс Main.
