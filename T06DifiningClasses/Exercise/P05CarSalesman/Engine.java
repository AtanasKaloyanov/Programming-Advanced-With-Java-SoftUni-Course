package T06DifiningClasses.Exercise.P05CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder engineSb = new StringBuilder();
        engineSb.append(this.model).append(":\n");
        engineSb.append("Power: ").append(this.power).append("\n");
        engineSb.append("Displacement: ").append(this.displacement).append("\n");
        engineSb.append("Efficiency: ").append(this.efficiency);
        return engineSb.toString();
    }
}
