package T11ExamPreparation.E04October2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            String currentName = person.getName();
            if (currentName.equals(name)) {
                roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson (String name, String town) {

        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(town)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the T11ExamPreparation.E04October2021.hotel %s are:", name)).append("\n");
        for (Person person : roster) {
            sb.append(person).append("\n");
        }
        return sb.toString().trim();
    }

}
