package T06DifiningClasses.Lab.P02CarConstructors;

public class CarConstructors {
     String brand;
     String model;
     int horsePower;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public int getHorsePower() {
        return horsePower;
    }

    public CarConstructors(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public CarConstructors(String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                getBrand(), getModel(), getHorsePower());
    }

}
