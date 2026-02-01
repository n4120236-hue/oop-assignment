import java.util.List;
import java.util.stream.Collectors;

public class MenuService {
    private final CrudRepository<MenuItem> repository;

    public MenuService(CrudRepository<MenuItem> repository) {
        this.repository = repository;
    }

    public void addItem(MenuItem item) {
        if (!item.validate()) throw new IllegalArgumentException("Invalid item");
        repository.save(item);
    }

    public List<MenuItem> getSortedItems() {
        List<MenuItem> items = repository.findAll();
        items.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        return items;
    }

    public List<MenuItem> filterByPrice(double minPrice) {
        return repository.findAll().stream()
                .filter(item -> item.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }
}