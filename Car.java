import java.util.ArrayList;

public class Car implements CarRequirements {

    private ArrayList<Passenger> passengers;
    private int maxCapacity;
    
    /**
     * constructor
     * @param maxCapacity
     */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Passenger>();
    }
    
    /**
     * a public method of getting the capacity from main
     */
    public int getCapacity() {
        return this.maxCapacity;
    }
    
    /**
     * a public method of getting the capacity from main
     */
    public int seatsRemaining() {
        return this.maxCapacity - this.passengers.size();
    }
    
    /**
     * add a passenger in to the train
     */
    public Boolean addPassenger(Passenger p) {
        if (this.seatsRemaining() > 0) {
            this.passengers.add(p);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Remove a passenger from the train
     */
    public Boolean removePassenger(Passenger p) {
        if (this.passengers.contains(p)) {
            this.passengers.remove(p);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Print the list of all the passenger
     */
    public void printManifest() {
        if (this.passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("Passenger manifest:");
            for (Passenger p : passengers) {
                System.out.println("- " + p.getName());
            }
        }
    }
}