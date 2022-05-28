package T08Generics.Lab.P02GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
          ArrayCreator arrayCreator = new ArrayCreator();

          ArrayCreator.create(5, "Pesho");
          ArrayCreator.create(String.class, 5, "Pesho");



    }
}
