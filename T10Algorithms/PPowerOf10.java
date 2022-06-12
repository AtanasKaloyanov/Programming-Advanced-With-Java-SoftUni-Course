package T10Algorithms;

public class PPowerOf10 {
    public static void main(String[] args) {
        System.out.println(powerOf10(4));
    }

    public static int powerOf10(int number) {
        if (number == 0) {
            return 1;
        }
        return 10 * powerOf10(number - 1);
    }
}
