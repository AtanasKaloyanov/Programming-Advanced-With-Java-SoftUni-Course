package T06DifiningClasses.Exercise.P03SpeedRacing;

public class Car {
    //Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer, and distance traveled.
    private String model;
    private double fuelAmount;
    private double fuelFor1Kilometer;
    private int amountKilometers;



    public Car(String model, int fuelAmount, double fuelFor1Kilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelFor1Kilometer = fuelFor1Kilometer;
        this.amountKilometers = 0;
    }


    public int getAmountKilometers() {
        return amountKilometers;
    }

    public void setFuelAmount(int distance) {
        this.fuelAmount = fuelAmount - fuelFor1Kilometer * distance;
    }

    public void setAmountKilometers(int distance) {
        this.amountKilometers += distance;
    }


    public boolean isTheFuelEnough(int distance) {
        if (fuelAmount < fuelFor1Kilometer * distance) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(model + " ").append(String.format("%.2f ", fuelAmount)).append(amountKilometers);

        return builder.toString();
     }

}
