package T09IteratorsAndComparators.Exercise.P06StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int result =  Integer.compare(firstPerson.getName().length(),(secondPerson.getName().length()));
        if (result == 0) {
            result =  Character.compare(firstPerson.getName().toUpperCase().charAt(0), secondPerson.getName().toUpperCase().charAt(0));
        }
        return result;
    }
}
