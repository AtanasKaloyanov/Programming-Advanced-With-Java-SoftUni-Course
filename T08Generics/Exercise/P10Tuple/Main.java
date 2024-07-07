package T08Generics.Exercise.P10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Object scanner creating for input reading:
        Scanner scanner = new Scanner(System.in);

        // 2. Tuples creating:
        // 2.1. Tuple1
        String[] info1 = scanner.nextLine().split(" ");
        String name = info1[0] + " " + info1[1];
        String town = info1[2];
        Tuple<String, String> tuple1 = new Tuple<>(name, town);

        // 2.2. Tuple2:
        String[] info2 = scanner.nextLine().split(" ");
        String name2 = info2[0];
        int litersBeer = Integer.parseInt(info2[1]);
        Tuple<String, Integer> tuple2 = new Tuple<>(name2, litersBeer);

        // 2.3. Tuple3:
        String[] info3 = scanner.nextLine().split(" ");
        int number = Integer.parseInt(info3[0]);
        double realNumber = Double.parseDouble(info3[1]);
        Tuple<Integer, Double> tuple3 = new Tuple<>(number, realNumber);

        // 3. Printing:
        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
