package T06DifiningClasses.Exercise.P07Google;

public class Pokemon {
    private String name;
    private String element;

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
    }

    @Override
    public String toString() {
        return this.name + " " + this.element;
    }
}
