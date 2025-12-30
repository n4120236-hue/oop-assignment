public class Truck extends Vehicle {
    private double capacity;
    private int numAxles;

    public Truck(String brand, int year, double capacity, int numAxles) {
        super(brand, year);
        this.capacity = capacity;
        this.numAxles = numAxles;
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " камаз заводиться");
    }

    @Override
    public void stopEngine() {
        System.out.println(brand + " камаз заглох");
    }
}
