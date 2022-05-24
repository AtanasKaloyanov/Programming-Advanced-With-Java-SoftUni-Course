package T06DifiningClasses.Exercise.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person() {
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company.toString()).append("\n");
        }

        builder.append("Car:").append("\n");

        if (car != null) {
            builder.append(car.toString()).append("\n");
        }

        builder.append("Pokemon:").append("\n");

        for (Pokemon pokemon : pokemonList) {
            builder.append(pokemon.toString()).append("\n");
        }

        builder.append("Parents:").append("\n");

        for (Parents parents : parentsList) {
            builder.append(parents.toString()).append("\n");
        }

        builder.append("Children:").append("\n");

        for (Children children : childrenList) {
            builder.append(children.toString()).append("\n");
        }

        return builder.toString();

        //Company:
        //JeleInc Jelior 777.77
        //Car:
        //AudiA4 180
        //Pokemon:
        //Onyx Rock
        //Charizard Fire
        //Parents:
        //SaraJohnson 13/03/1933
        //Children:
        //SamJohnson 01/01/2001
    }
}
