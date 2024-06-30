package T06DifiningClasses.Exercise.P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder carSb = new StringBuilder();
        carSb.append(this.model).append(":\n");
        carSb.append(this.engine).append("\n");
        carSb.append("Weight: ").append(this.weight).append("\n");
        carSb.append("Color: ").append(this.color);
        return carSb.toString();
    }
}
