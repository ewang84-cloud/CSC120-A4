public class Engine {

    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;
    
    /**
     * constructor
     */
    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
     this.fuelType = fuelType;
     this.currentFuelLevel = currentFuelLevel;
     this.maxFuelLevel = maxFuelLevel;
    }
    
    /**
     * Get Fuel type: a public method to allow main to get Fuel Type
     */
    public FuelType getFuelType() {
        return this.fuelType;
    }
    
    /**
     * Get Fuel Level: a public method to allow main to get Fuel Level
     */
    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }
    
    /**
     * Get Fuel Max Level: a public method to allow main to get Fuel Max Level
     */
    public double getMaxFuelLevel() {
        return this.maxFuelLevel;
    }
    
    /**
     * Refuel: add fuel to max
     */
    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel;
    }
    
    /**
     * use the fuel, if there's 
     */
    public boolean go() {
        this.currentFuelLevel -= 10.0;
        System.out.println("Remaining fuel: " + this.currentFuelLevel);
        
        if (this.currentFuelLevel > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * testing
     */
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}