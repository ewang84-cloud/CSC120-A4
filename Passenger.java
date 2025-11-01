public class Passenger {
    
    private String name;

    /**
     * constructor
     * @param name name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }
    
    /**
     * get name of the passenger
     * @return the name of the passenger
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * a passenger gets on the car
     * @param c the car to board
     */
    public void boardCar(Car c) {
        boolean success = c.addPassenger(this);
        
        if (success) {
            System.out.println(this.name + " has boarded the car.");
        } else {
            System.out.println(this.name + " could not board, car is full!");
        }
    }
    
    /**
     * a passenger gets off the car
     * @param c the car to get off from
     */
    public void getOffCar(Car c) {
        boolean success = c.removePassenger(this);
        
        if (success) {
            System.out.println(this.name + " has gotten off the car.");
        } else {
            System.out.println(this.name + " was not on this car!");
        }
    }
}
