import controller.RestaurantController;
import service.MenuService;
import repository.MenuItemRepository;
import utils.DatabaseConnection;
import utils.ReflectionUtils;
import model.Dish;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            MenuItemRepository repo = new MenuItemRepository(conn);
            MenuService service = new MenuService(repo);
            RestaurantController controller = new RestaurantController(service);

            ReflectionUtils.inspectClass(new Dish(0, "", 0, false));

            controller.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}