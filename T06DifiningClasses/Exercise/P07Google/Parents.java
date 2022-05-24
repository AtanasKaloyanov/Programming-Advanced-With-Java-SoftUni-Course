package T06DifiningClasses.Exercise.P07Google;

public class Parents {
    private String parantName;
    private String birthday;

    public Parents(String parantName, String birthday) {
        this.parantName = parantName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", parantName, birthday);
    }
}
