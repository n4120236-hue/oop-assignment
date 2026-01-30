package service;

import model.MenuItem;
import repository.interfaces.CrudRepository;
import interfaces.Validatable;
import exception.InvalidInputException;
import java.util.List;

public class MenuService implements Validatable<MenuItem> {
    private final CrudRepository<MenuItem> repository;

    public MenuService(CrudRepository<MenuItem> repository) {
        this.repository = repository;
    }

    public void processNewItem(MenuItem item) throws InvalidInputException {
        logValidation(item.getName());
        validate(item);
        repository.create(item);
    }

    public List<MenuItem> getSortedMenu() {
        List<MenuItem> items = repository.findAll();
        // Lambda expression for sorting [cite: 53-57]
        items.sort((a, b) -> Double.compare(a.getBasePrice(), b.getBasePrice()));
        return items;
    }

    @Override
    public void validate(MenuItem item) throws InvalidInputException {
        if (!Validatable.isPositive(item.getBasePrice())) {
            throw new InvalidInputException("Price must be positive!");
        }
    }
}