package T06DifiningClasses.Exercise.P09CatLady;

public class StreetExtraordinaire extends Cat{
    private double decibelsOfMeows;
    public StreetExtraordinaire(String breed, String name, double decibelsOfMeows) {
        super(breed, name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public double getDecibelsOfMeows() {
        return this.decibelsOfMeows;
    }

    @Override
    public String toString() {
        return super.getBreed() + " " + super.getName() + " " + String.format("%.2f", this.getDecibelsOfMeows());
    }
}
