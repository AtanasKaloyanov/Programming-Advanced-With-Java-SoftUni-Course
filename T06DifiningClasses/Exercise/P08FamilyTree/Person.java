package T06DifiningClasses.Exercise.P08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<String> parentsInfos = new ArrayList<>();
    private List<String> childrenInfos = new ArrayList<>();

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getParentsInfos() {
        return parentsInfos;
    }

    public List<String> getChildrenInfos() {
        return childrenInfos;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthday;
    }
}

