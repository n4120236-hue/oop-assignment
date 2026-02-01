public class Dish extends MenuItem {
    private boolean isSpicy;

    public Dish(int id, String name, double price, boolean isSpicy) {
        super(id, name, price);
        this.isSpicy = isSpicy;
    }

    @Override
    public String getCategory() { return "Dish"; }

    @Override
    public double calculateDiscount() { return getPrice() * 0.1; }
}