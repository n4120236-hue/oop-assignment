import model.*;
import repository.MenuRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuRepository repo = new MenuRepository();

        try {
            FoodItem burger = new FoodItem(0, "Cheeseburger", 1800, "Grill");
            repo.save(burger);

            List<MenuItem> menu = repo.findAll();
            for (MenuItem item : menu) {
                System.out.println(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}