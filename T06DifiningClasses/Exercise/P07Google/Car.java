package T06DifiningClasses.Exercise.P07Google;

public class Car {
    private String carModel;
    private double carSpeed;

    public Car(String carModel, double carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %.0f", carModel, carSpeed);
    }
}
