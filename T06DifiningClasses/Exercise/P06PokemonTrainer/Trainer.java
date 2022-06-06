package T06DifiningClasses.Exercise.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges() {
        this.badges++;
    }


    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemonList.size());
    }
}
