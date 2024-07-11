package T09IteratorsAndComparators.Exercise.P08PetClinics;

public class Clinic {
    private String name;
    private int rooms;
    private Pet[] pets;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
        this.pets = new Pet[this.rooms];
    }

    public Pet[] getPets() {
        return this.pets;
    }

    public int getRooms() {
        return this.rooms;
    }

}
