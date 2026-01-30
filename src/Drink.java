package model;
public class Drink extends MenuItem {
    private double volume;

    public Drink(int id, String name, double price, double volume) {
        super(id, name, price);
        this.volume = volume;
    }

    @Override
    public double calculateTax() { return getBasePrice() * 0.20; }

    @Override
    public String getType() { return "Drink (" + volume + "L)"; }
}