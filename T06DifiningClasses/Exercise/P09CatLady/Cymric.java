package T06DifiningClasses.Exercise.P09CatLady;

public class Cymric extends Cat{
    private double furLength;
    public Cymric(String breed, String name, double furLength) {
        super(breed, name);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return this.furLength;
    }

    @Override
    public String toString() {
        return this.getBreed() + " " + this.getName() + " " + String.format("%.2f", this.getFurLength());
    }
}
