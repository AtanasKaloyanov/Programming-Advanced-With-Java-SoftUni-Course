package T06DifiningClasses.Exercise.P05CarSalesman;

import java.util.Locale;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String colour;

    public Car(String model, Engine engine, int weight, String colour) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(model).append(":").append("\n");
        sb.append(engine.getModel()).append(":").append("\n");
        sb.append("Power: ").append(engine.getPower()).append("\n");
        sb.append("Displacement: ");
        if (engine.getDisplacement() == 0) {
            sb.append("n/a").append("\n");
        } else {
            sb.append(engine.getDisplacement()).append("\n");
        }

        sb.append("Efficiency: ");
        if (engine.getEfficiency() == null) {
            sb.append("n/a").append("\n");
        } else {
            sb.append(engine.getEfficiency()).append("\n");
        }
        sb.append("Weight: ");
        if (weight == 0) {
            sb.append("n/a").append("\n");
        } else {
            sb.append(weight).append("\n");
        }
        sb.append("Color: ");
        if (colour == null) {
            sb.append("n/a").append("\n");
        } else {
            sb.append(colour).append("\n");
        }

        return sb.toString();
    }
}
