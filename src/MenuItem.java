package model;

public abstract class MenuItem {
    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
//s
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract String getCategory();
    public abstract String getDetails();

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f tg", getCategory(), name, price);
    }
}