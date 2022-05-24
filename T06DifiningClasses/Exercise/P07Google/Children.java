package T06DifiningClasses.Exercise.P07Google;

public class Children {
    private String childName;
    private String birthday;

    public Children(String childName, String birthday) {
        this.childName = childName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", childName, birthday);
    }
}
