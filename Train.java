import java.util.ArrayList;

public class Train implements TrainRequirements {

    private Engine engine;
    private ArrayList<Car> cars;
    
    /**
     * constructor
     * @param fuelType
     * @param currentFuelLevel 
     * @param fuelCapacity
     * @param nCars 
     * @param passengerCapacity 
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, 
                 int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<Car>();
            for (int i = 0; i < nCars; i++) {
            Car newCar = new Car(passengerCapacity);
            this.cars.add(newCar);
        }
    }
    
    /**
     * get the engine
     */
    @Override
    public Engine getEngine() {
        return this.engine;
    }
    
    /**
     * get the car from the array
     * @param i the number of the car in the Arraylist that's getting
     */
    @Override
    public Car getCar(int i) {
        return this.cars.get(i);
    }
    
    /**
     * get the total number of the cars in the trains
     */
    @Override
    public int getMaxCapacity() {
        int totalCapacity = 0;
        for (Car car : this.cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }
    
    /**
     * get the remaining seats
     */
    @Override
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for (Car car : this.cars) {
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }
    
    /**
     * print the list of all the passenger
     */
    @Override
    public void printManifest() {
        System.out.println("===== TRAIN MANIFEST =====");
        for (int i = 0; i < this.cars.size(); i++) {
            System.out.println("\nCar " + (i + 1) + ":");
            this.cars.get(i).printManifest();
        }
        System.out.println("\n==========================");
    }
    
    /**
     * testing
     */
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 100.0, 100.0, 3, 5);
        
        Passenger alice = new Passenger("Alice");
        Passenger bob = new Passenger("Bob");
        Passenger charlie = new Passenger("Charlie");
        
        alice.boardCar(myTrain.getCar(0));
        bob.boardCar(myTrain.getCar(0));
        charlie.boardCar(myTrain.getCar(1));
        
        myTrain.printManifest();
        
        System.out.println("\nStarting the train...");
        for (int i = 0; i < 5; i++) {
            if (myTrain.getEngine().go()) {
                System.out.println("Choo choo!");
            } else {
                System.out.println("Out of fuel!");
                break;
            }
        }
    }
}