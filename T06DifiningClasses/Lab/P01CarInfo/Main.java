package T06DifiningClasses.Lab.P01CarInfo;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Creating n time Car object and printing it:
        for (int i = 1; i <= n ; i++) {
           String[] array = scanner.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(array[0]);
            car.setModel(array[1]);
            car.setHorsePower(Integer.parseInt(array[2]));

            System.out.print(car);
        }
    }
}
