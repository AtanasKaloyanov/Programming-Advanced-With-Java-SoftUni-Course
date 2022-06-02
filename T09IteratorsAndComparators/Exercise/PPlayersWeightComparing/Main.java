package T09IteratorsAndComparators.Exercise.PPlayersWeightComparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Vince Carter", 198, 100);
        Player secondPlayer = new Player("Michael Jordan", 198, 98);
        Player thirdPlayer = new Player("Zion Williamson",198, 129);

        List<Player> playerList = new ArrayList<>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer));
        Collections.sort(playerList);

        playerList.stream().forEach(player -> System.out.printf("%s - %d - %d%n", player.getName(), player.getHeight(), player.getWeight()));
    }
}
