package interfaces;
import exception.InvalidInputException;

public interface Validatable<T> {
    void validate(T entity) throws InvalidInputException;

    default void logValidation(String name) {
        System.out.println("[System] Validating item: " + name);
    }

    static boolean isPositive(double val) {
        return val > 0;
    }
}