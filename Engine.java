public class Engine implements EngineRequirements{

    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;
    
    /**
     * constructor
     */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel) {
     this.fuelType = fuelType;
     this.currentFuel = currentFuel;
     this.maxFuel = maxFuel;
    }
    
    /**
     * Get Fuel type: a public method to allow main to get Fuel Type
     */
    @Override
    public FuelType getFuelType() {
        return this.fuelType;
    }
    
    /**
     * Get Fuel Level: a public method to allow main to get Fuel Level
     */
    @Override
    public double getCurrentFuel() {
        return this.currentFuel;
    }
    
    /**
     * Get Fuel Max Level: a public method to allow main to get Fuel Max Level
     */
    @Override
    public double getMaxFuel() {
        return this.maxFuel;
    }
    
    /**
     * Refuel: add fuel to max
     */
    @Override
    public void refuel() {
        this.currentFuel = this.maxFuel;
    }
    
    /**
     * use the fuel, if there's 
     */
    @Override
    public Boolean go() {
        this.currentFuel -= 10.0;
        System.out.println("Remaining fuel: " + this.currentFuel);
        
        if (this.currentFuel > 0) {
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