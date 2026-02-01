public class Drink extends MenuItem {
    private double volume;

    public Drink(int id, String name, double price, double volume) {
        super(id, name, price);
        this.volume = volume;
    }

    @Override
    public String getCategory() { return "Drink"; }

    @Override
    public double calculateDiscount() { return getPrice() * 0.05; }
}