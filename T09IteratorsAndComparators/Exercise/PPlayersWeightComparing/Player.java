package T09IteratorsAndComparators.Exercise.PPlayersWeightComparing;

public class Player implements Comparable<Player> {
    private String name;
    private int height;
    private int weight;

    public Player(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Player basketballPlayer) {
        return Integer.compare(this.weight, basketballPlayer.getWeight());
    }
}
