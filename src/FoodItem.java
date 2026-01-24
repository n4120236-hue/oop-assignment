package model;

public class FoodItem extends MenuItem {
    private String cookingMethod;

    public FoodItem(int id, String name, double price, String cookingMethod) {
        super(id, name, price);
        this.cookingMethod = cookingMethod;
    }

    @Override
    public String getCategory() { return "FOOD"; }

    @Override
    public String getDetails() {
        return cookingMethod;
    }
}