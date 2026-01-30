package model;
public abstract class MenuItem {
    private int id;
    private String name;
    private double basePrice;

    public MenuItem(int id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }

    public abstract double calculateTax();
    public abstract String getType();

    public final double getFinalPrice() {
        return basePrice + calculateTax();
    }
}