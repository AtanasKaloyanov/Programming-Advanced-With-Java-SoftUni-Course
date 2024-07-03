package T06DifiningClasses.Exercise.P07Google;

public class Car {
    private String name;
    private int years;

    public Car(String name, int years) {
        this.name = name;
        this.years = years;
    }

    @Override
    public String toString() {
        return this.name + " " + this.years;
    }
}
