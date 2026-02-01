public interface Validatable<T> {
    boolean validate();
    default void printStatus() {
        System.out.println("Validation check performed.");
    }
    static boolean isNotNull(Object obj) {
        return obj != null;
    }
}