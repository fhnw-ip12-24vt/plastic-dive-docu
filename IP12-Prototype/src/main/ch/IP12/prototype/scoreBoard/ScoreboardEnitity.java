package main.ch.IP12.prototype.scoreBoard;

public class ScoreboardEnitity {
    long score;
    String name;

    /**
     * Creates a scoreboard entity.
     * @param score The score the entity will hold.
     * @param name The name that is associated with the entity.
     */
    public ScoreboardEnitity(long score, String name) {
        this.score = score;
        this.name = name;
    }
}
