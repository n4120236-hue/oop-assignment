public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Yershadi Nurassyl", "707POP17");
        Driver driver2 = new Driver("Serikov Dias", "111TAS06");

        Car myCar = new Car("Mersedes Bebz", 2026, 5, "Turbo engine");
        myCar.setDriver(driver1);

        Motorcycle myMoto = new Motorcycle("Yamazaki", 2017, false);
        myMoto.setDriver(driver1);

        Truck myTruck = new Truck("BMW", 2022, 15.5, 4);
        myTruck.setDriver(driver2);

        Vehicle[] fleet = {myCar, myMoto, myTruck};

        for (Vehicle v : fleet) {
            v.displayInfo();
            v.startEngine();
            v.stopEngine();
        }
    }
}