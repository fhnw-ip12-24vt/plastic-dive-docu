package main.ch.IP12.prototype.scoreBoard;

import java.io.IOException;
import java.util.*;

public class Scoreboard {
    //scoreboard list of scores and when
    private final Map<String, Long> scoreboard = new TreeMap<>();

    Scoreboard(){
        try{
            insertValues();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //return highest score value
    public Long getHighscore(){
        Long t = 0L;
        for (Long i : scoreboard.values()){
            if (i > t){
                t = i;
            }
        }
        return t;
    }

    //print Entire scoreboard
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
        list.sort(comparator);
        return list.toArray(new ScoreboardEnitity[0]);
    }

    //refresh values inside scoreboard
    public void insertValues() throws IOException {
        DataDealer d = DataDealer.getInstance("Highscore.json");
        scoreboard.clear();
        scoreboard.putAll(d.getValues());
    }
}
