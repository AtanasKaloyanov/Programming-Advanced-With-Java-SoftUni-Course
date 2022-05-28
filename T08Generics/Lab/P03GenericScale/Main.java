package T08Generics.Lab.P03GenericScale;

public class Main {
    public static void main(String[] args) {
        String firstElement = "first";
        String secondElement = "second";

        Scale<String> scale = new Scale<>(firstElement, secondElement);
        System.out.println(scale.getHeavier());
    }

}
