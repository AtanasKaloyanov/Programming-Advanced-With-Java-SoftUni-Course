package T11ExamPreparation.E12February2020.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private List<Player> roster;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = this.roster.stream().filter(element -> element.getClazz().equals(clazz)).collect(Collectors.toList());
       this.roster.removeAll(list);
        return list.toArray(Player[]::new);

        //List<Player> playersToRemove = this.roster.stream().filter(s -> s.getClazz().equals(clazz)).collect(Collectors.toList());
        // this.roster.removeAll(playersToRemove);
        // return playersToRemove.toArray(Player[]::new);

    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the T11ExamPreparation.E12February2020.guild: %s:", name)).append("\n");
        for (Player player : roster) {
            sb.append(player).append("\n");
        }
        return sb.toString().trim();
    }
}
