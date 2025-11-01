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
    @Override
    public int getCapacity() {
        return this.maxCapacity;
    }
    
    /**
     * a public method of getting the capacity from main
     */
    @Override
    public int seatsRemaining() {
        return this.maxCapacity - this.passengers.size();
    }
    
    /**
     * add a passenger in to the train
     * @param p the passenger that we're adding to the car
     */
    @Override
    public Boolean addPassenger(Passenger p) {
        if (this.passengers.contains(p)){
            System.out.println(p.getName() + "is already on the car!");
            return false;
        }
        
        if (this.seatsRemaining() > 0) {
            this.passengers.add(p);
            return true;
        } else {
            System.out.println("No more seats available");
            return false;
        }
    }
    
    /**
     * Remove a passenger from the train
     * @param p the passenger that we're removing from the car
     */
    @Override
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
    @Override
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