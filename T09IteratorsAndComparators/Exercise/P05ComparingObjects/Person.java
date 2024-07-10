package T09IteratorsAndComparators.Exercise.P05ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person second) {
        int compareNumber = this.getName().compareTo(second.getName());
        if (compareNumber == 0) {
            compareNumber = Integer.compare(this.getAge(), second.getAge());
        }
        if (compareNumber == 0) {
            compareNumber = this.getTown().compareTo(second.getTown());
        }
        return compareNumber;
    }
}
