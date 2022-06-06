package T06DifiningClasses.Exercise.P06PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Trainer> map = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] array = input.split("\\s+");
            String trainerName = array[0];
            String pokemonName = array[1];
            String pokemonElement = array[2];
            int pokemonHealth = Integer.parseInt(array[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            map.putIfAbsent(trainerName, new Trainer(trainerName));
            map.get(trainerName).getPokemonList().add(pokemon);

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {
            String givenElement = secondInput;

            map.values().forEach(trainer -> {
                boolean hasElement = false;
                for (Pokemon pokemon : trainer.getPokemonList()) {
                    if (pokemon.getElement().equals(givenElement)) {
                        trainer.setBadges();
                        hasElement = true;
                        break;
                    }
                }

                if (!hasElement) {
                    trainer.getPokemonList().forEach(pokemon -> pokemon.setHealth());
                    trainer.getPokemonList().removeIf(pokemon -> pokemon.getHealth() <= 0);
                }


            });

            secondInput = scanner.nextLine();
        }

        map.entrySet().stream().sorted(
                (firstEntry, secondEntry) -> {
                    int result = Integer.compare(secondEntry.getValue().getBadges(), firstEntry.getValue().getBadges());

                    return result;
                }).forEach(entry -> System.out.println(entry.getValue()));

    }
}
