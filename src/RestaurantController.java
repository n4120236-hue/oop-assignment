package controller;
import service.MenuService;
import model.*;

public class RestaurantController {
    private final MenuService service;

    public RestaurantController(MenuService service) {
        this.service = service;
    }

    public void runDemo() {
        try {
            Dish pizza = new Dish(1, "Pepperoni", 12.0, false);
            service.processNewItem(pizza);
            System.out.println("Menu sorted:");
            service.getSortedMenu().forEach(i -> System.out.println(i.getName()));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}