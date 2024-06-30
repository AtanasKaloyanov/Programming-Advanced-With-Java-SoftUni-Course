package T06DifiningClasses.Exercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getFuelCostFor1Km() {
        return this.fuelCostFor1Km;
    }

    public void travelDistance(double fuel, double distance) {
        this.fuelAmount -= fuel;
        this.distanceTravelled += distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }
}
