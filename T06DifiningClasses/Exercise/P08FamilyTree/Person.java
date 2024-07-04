package T06DifiningClasses.Exercise.P08FamilyTree;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name;
    private int birthday;
    private Set<Person> parents = new LinkedHashSet<>();
    private Set<Person> children = new LinkedHashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(int birthday) {
        this.birthday = birthday;
    }
}

