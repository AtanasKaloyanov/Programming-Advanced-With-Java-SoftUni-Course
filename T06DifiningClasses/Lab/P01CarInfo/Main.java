package T06DifiningClasses.Lab.P01CarInfo;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {
           String[] array = scanner.nextLine().split(" ");
            Car car = new Car();

            car.setBrand(array[0]);
            car.setModel(array[1]);
            car.setHorsePower(Integer.parseInt(array[2]));

            System.out.print(String.format("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsePower()));
        }
    }
}
