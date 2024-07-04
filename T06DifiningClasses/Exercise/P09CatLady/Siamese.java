package T06DifiningClasses.Exercise.P09CatLady;

public class Siamese extends Cat {
    private double earSize;
     public Siamese(String breed, String name, double earSize) {
         super(breed, name);
         this.earSize = earSize;
     }

     public double getEarSize() {
         return this.earSize;
     }

     @Override
     public String toString() {
         return super.getBreed() + " " + super.getName() + " " + String.format("%.2f", this.getEarSize());
     }
}
