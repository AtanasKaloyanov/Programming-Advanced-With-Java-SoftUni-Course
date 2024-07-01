package T06DifiningClasses.Exercise.P06PokemonTrainer;

import java.util.HashSet;
import java.util.Set;

public class Trainer {
    private String name;
    private int badges;
    private Set<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public Set<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
