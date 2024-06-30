package T06DifiningClasses.Exercise.P01OpinionPoll;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person second) {
        return this.name.compareTo(second.name);
    }

    @Override
    public String toString() {
        return this.name + " - " + this.age;
    }
}
