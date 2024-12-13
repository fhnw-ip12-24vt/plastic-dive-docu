package ch.IP12.prototype.scoreBoard;

import java.io.IOException;
import java.util.*;

public class Scoreboard {
    //scoreboard list of scores and when
    private final Map<String, Long> scoreboard = new TreeMap<>();
    private static Scoreboard instance = null;

    private Scoreboard(){
        try{
            insertValues();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Scoreboard getInstance(){
        if (instance == null){
            instance = new Scoreboard();
        }
        return instance;
    }

    /**
     * @return Highest score value on the leaderboard
     */
    public ScoreboardEnitity getHighscore(){
        Long t = 0L;
        String prevKey = "";
        for (String i : scoreboard.keySet()){
            if (prevKey.isEmpty()){
                t = scoreboard.get(i);
                prevKey = i;
            } else if (scoreboard.get(i) > scoreboard.get(prevKey)){
                t = scoreboard.get(i);
                prevKey = i;
            }
        }
        return new ScoreboardEnitity(t, prevKey);
    }

    /**
     * Returns entire scoreboard.
     * @return All the entries in the Scoreboard.
     */
    public ScoreboardEnitity[] getList(){
        ArrayList<ScoreboardEnitity> list = new ArrayList<>();
        for (String i : scoreboard.keySet()){
            StringBuilder temp = new StringBuilder(i);
            while (temp.length() < 10){
                temp.append(" ");
            }
            if (temp.length() > 10){
                temp = new StringBuilder(temp.substring(0, 10));
            }
            list.add(new ScoreboardEnitity(scoreboard.get(i), temp.toString()));
        }
        ScoreboardComparer comparator = new ScoreboardComparer();
        //noinspection unchecked
        list.sort(comparator);
        return list.toArray(new ScoreboardEnitity[0]);
    }

    /**
     * Update values in the scoreboard
     * @throws IOException File interaction warrants possible errors.
     */
    public void insertValues() throws IOException {
        DataDealer d = DataDealer.getInstance("Highscore.json");
        scoreboard.clear();
        scoreboard.putAll(d.getValues());
    }
}
