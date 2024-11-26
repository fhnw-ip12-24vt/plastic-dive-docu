package main.ch.IP12.prototype.scoreBoard;

import java.util.Comparator;

public class ScoreboardComparer implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof ScoreboardEnitity && o2 instanceof ScoreboardEnitity) {
            return (int)(((ScoreboardEnitity) o1).score - ((ScoreboardEnitity) o2).score);
        }
        return 0;
    }
}
