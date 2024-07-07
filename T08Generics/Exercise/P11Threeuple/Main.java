package T08Generics.Exercise.P11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an object of the class Scanner:
        Scanner scanner = new Scanner(System.in);

        // 2. Treeuples info reading:
        // 2.1. Tuple1
        String[] info1 = scanner.nextLine().split(" ");
        String name = info1[0] + " " + info1[1];
        String neighbourhood = info1[2];
        String town = info1[3];
        Treeuple<String, String, String> treeuple1 = new Treeuple<>(name, neighbourhood, town);

        // 2.2. Tuple2
        String[] info2 = scanner.nextLine().split(" ");
        String name2 = info2[0];
        int liters = Integer.parseInt(info2[1]);
        boolean isDrunk = info2[2].equals("drunk");
        Treeuple<String, Integer, Boolean> treeuple2 = new Treeuple<>(name2, liters, isDrunk);

        // 2.3. Tuple3
        String[] info3 = scanner.nextLine().split(" ");
        String name3 = info3[0];
        double balance = Double.parseDouble(info3[1]);
        String bankName = info3[2];
        Treeuple<String, Double, String> treeuple3 = new Treeuple<>(name3, balance, bankName);

        // 3. Treeuple printing:
        System.out.println(treeuple1);
        System.out.println(treeuple2);
        System.out.println(treeuple3);
    }
}
