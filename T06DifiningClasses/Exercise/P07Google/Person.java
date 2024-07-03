package T06DifiningClasses.Exercise.P07Google;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private Set<Parent> parents = new LinkedHashSet<>();
    private Set<Child> children = new LinkedHashSet<>();
    private Set<Pokemon> pokemons = new LinkedHashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // 1. person name
        sb.append(this.name).append("\n");
        // 2. company
        sb.append("Company:").append("\n");
        if (this.company != null) {
            sb.append(this.company).append("\n");
        }
        // 3. car
        sb.append("Car:").append("\n");
        if (this.car != null) {
            sb.append(this.car).append("\n");
        }
        // 4. pokemon
        sb.append("Pokemon:").append("\n");
        for (Pokemon pokemon : this.pokemons) {
            sb.append(pokemon).append("\n");
        }
        // 5. parents
        sb.append("Parents:").append("\n");
        for (Parent parent : this.parents) {
            sb.append(parent).append("\n");
        }
        // 6. children:
        sb.append("Children:").append("\n");
        for (Child child : this.children) {
            sb.append(child).append("\n");
        }
        return sb.toString();
    }
}
