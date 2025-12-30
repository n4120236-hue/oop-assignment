public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }
    @Override
    public void startEngine() {
        System.out.println(brand + " Мотоцикл заводиться");
    }

    @Override
    public void stopEngine() {
        System.out.println(brand + " Мотоцикл заглох");
}