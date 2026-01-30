package model;
public class Dish extends MenuItem {
    private boolean isVegetarian;

    public Dish(int id, String name, double price, boolean isVegetarian) {
        super(id, name, price);
        this.isVegetarian = isVegetarian;
    }

    @Override
    public double calculateTax() { return getBasePrice() * 0.10; }

    @Override
    public String getType() { return isVegetarian ? "Veg Dish" : "Meat Dish"; }
}