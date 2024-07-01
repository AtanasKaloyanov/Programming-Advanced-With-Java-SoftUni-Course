package T06DifiningClasses.Exercise.P06PokemonTrainer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // 2. Adding trainers to a LinkedHashMap:
        Map<String, Trainer> trainersByName = new LinkedHashMap<>();
        while (!line.equals("Tournament")) {
            String[] array = line.split(" ");
            String trainerName = array[0];

            // 2.1. Creating a pokemon:
            String pokemonName = array[1];
            String pokemonElement = array[2];
            int pokemonHealth = Integer.parseInt(array[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            // 2.2. Initializing the trainer and adding the pokemon into the set:
            trainersByName.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer trainer = trainersByName.get(trainerName);
            trainer.getPokemons().add(pokemon);
            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        // 3. Checking if the trainer has a pokemon with a given element. If he/she has
        // then adding one badge to him/her. In other case decreasing every pokemon's health with 10 life.
        // If the pokemon dies then deleting it.
        while (!line.equals("End")) {
            String searchedElement = line;
            trainersByName.values()
                    .forEach( (trainer) -> {
                        boolean hasPokemonWithElement = hasSearchedPokemon(searchedElement, trainer);
                        if (hasPokemonWithElement) {
                            addNewBadge(trainer);
                        } else {
                            Set<Pokemon> trainersPokemons = trainer.getPokemons();
                            trainersPokemons.forEach(Main::decracreaseHealthWith10);
                            trainersPokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
                        }
                    });
            line = scanner.nextLine();
        }

        // 4. Output comparing and printing:
        trainersByName.values()
                .stream().sorted(trainerBadgesComparator())
                .forEach(System.out::println);
    }

    private static Comparator<Trainer> trainerBadgesComparator() {
        return Comparator.comparing(Trainer::getBadges).reversed();
    }

    private static void decracreaseHealthWith10(Pokemon pokemon) {
        int health = pokemon.getHealth();
        health -= 10;
        pokemon.setHealth(health);
    }

    private static void addNewBadge(Trainer trainer) {
        int newBadges = trainer.getBadges();
        newBadges++;
        trainer.setBadges(newBadges);
    }

    private static boolean hasSearchedPokemon(String searchedElement, Trainer trainer) {
        return trainer.getPokemons()
                .stream()
                .anyMatch((pokemon) ->
                        pokemon.getElement().equals(searchedElement));
    }
}

/*
class Pokemon:             class Trainer:
  String name                String name;
  String element;            int badges;
  int health;                Set<Pokemon> pokemons;

   Map<String, Trainer> trainersByName;

   Input 1:

    Peter - {1. Charizard-Fire-100, 2. Pikachu-Electricity-10}
    George- {1. Squirtle-Water-38}

    1. Fire
     Peter - {1. Charizard-Fire-100, 2. Pikachu-Electricity-10}  - 1
     George- {1. Squirtle-Water-28}

    2. Electricity
     Peter - {1. Charizard-Fire-100, 2. Pikachu-Electricity-10}  - 2
     George- {1. Squirtle-Water-18}

     Output 1:

     TrainerName badges pokemons
     Peter         2       2
     George        0       1

    Input 2:

    Sam -  {1. Blastoise-Water-18}
    Alex - {1. Pikachu-Electricity-22}
    John - {1. Kadabra-Psychic-90}

    1. Fire
     Sam -  {1. Blastoise-Water-8}
     Alex - {1. Pikachu-Electricity-12}
     John - {1. Kadabra-Psychic-80}

    2. Electricity
     Sam -  {}
     Alex - {1. Pikachu-Electricity-12} - 1
     John - {1. Kadabra-Psychic-70}

    3. Electricity
     Sam -  {}
     Alex - {1. Pikachu-Electricity- 2} - 1
     John - {1. Kadabra-Psychic-60}

     Output 2:

     TrainerName badges pokemons
      Alex -        1       1
      Sam -         0       0
      John -        0       1
 */
