package T11ExamPreparation.E12February2020.guild;

public class Player {

private String name;
private String clazz;
private String rank = "Trial";
private String description = "n/a";

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( String.format("Player %s: %s", name, clazz)).append("\n");
        sb.append(String.format("Rank: %s", rank)).append("\n");
        sb.append(String.format("Description: %s", description)).append("\n");

        return sb.toString().trim();
    }
}
