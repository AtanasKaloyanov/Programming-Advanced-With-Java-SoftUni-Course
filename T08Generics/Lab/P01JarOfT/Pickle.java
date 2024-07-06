package T08Generics.Lab.P01JarOfT;

public class Pickle {
    private static int idCounter;
    private int id;

    public Pickle() {
        idCounter++;
        this.id = idCounter;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
