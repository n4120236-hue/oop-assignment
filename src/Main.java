import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            MenuItemRepository repository = new MenuItemRepository(conn);
            MenuService service = new MenuService(repository);
            RestaurantController controller = new RestaurantController(service);

            MenuItem dish1 = new Dish(101, "Pasta Carbonara", 15.50, false);
            MenuItem drink1 = new Drink(102, "Iced Latte", 4.50, 0.4);

            System.out.println("--- Runtime Inspection ---");
            ReflectionUtils.inspectClass(dish1);

            service.addItem(dish1);
            service.addItem(drink1);

            System.out.println("\n--- Menu Presentation ---");
            controller.displaySortedMenu();

            dish1.printStatus();

            System.out.println("\n--- Filtering Example ---");
            List<MenuItem> cheapItems = service.filterByPrice(10.0);
            cheapItems.forEach(item -> System.out.println("Found: " + item.getName()));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}