package T06DifiningClasses.Exercise.P07Google;

public class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthday;
    }
}
