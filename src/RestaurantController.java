public class RestaurantController {
    private final MenuService menuService;

    public RestaurantController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void displaySortedMenu() {
        menuService.getSortedItems().forEach(item ->
                System.out.println(item.getInfo())
        );
    }
}