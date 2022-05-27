package T08Generics.Lab.P01JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(2);
        jar.add(3);
        System.out.println(jar.remove());

        Jar<String> secondJar = new Jar<>();
        secondJar.add("first");
        secondJar.add("second");
        secondJar.add("third");
        System.out.println(secondJar.remove());
    }
}
