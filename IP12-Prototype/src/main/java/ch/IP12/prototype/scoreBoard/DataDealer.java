package ch.IP12.prototype.scoreBoard;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataDealer {
    //variable for easy access to file
    private final String fileName;
    private final int sizeLimit;

    private static DataDealer instance = null;

    private DataDealer(String fileName, int boardSizeLimit) throws IOException {
        //check for file existence and creation if it doesn't
        boolean b;
        sizeLimit = boardSizeLimit;
        this.fileName = fileName;
        File f = new File(fileName);
        if(!f.exists()){
            b = f.createNewFile();
            assert b;
        }
        assert f.isFile();
    }

    public static DataDealer getInstance(String fileName) throws IOException {
        return getInstance(fileName, 10);
    }

    /**
     * Create an instance of the DataDealer object or returns it if one already exists.
     * @param fileName The name of the file that will be written to.
     * @param boardSizeLimit how large the leaderboard can be.
     * @return DataDealer instance
     * @throws IOException File interaction can throw an error, cannot be avoided.
     */
    public static DataDealer getInstance(String fileName, int boardSizeLimit) throws IOException {
        if(instance == null){
            instance = new DataDealer(fileName, boardSizeLimit);
        }
        return instance;
    }

    /**
     * Write score and the player's name to JSON file
     * @param name Name that the player chose
     * @param score The player's score
     */
    //IDE doesn't show warnings for "put" or "add" methods
    @SuppressWarnings("unchecked")
    public void dataStore(String name, long score){
        //create variables for JSON and content writing functionality
        boolean b = false;
        JSONObject json = new JSONObject();
        JSONObject finalO = new JSONObject();
        JSONArray jsonA = new JSONArray();

        //add values to JSON Object
        json.put("Name", name);
        json.put("Score", score);

        //write to file if it has entries already
        try {
            //add existing entries to JSON Array and write into file as new JSON object
            jsonA.addAll((JSONArray) JSONFileParser().get("Highscores"));
            jsonA.add(json);
            //shorten the list of objects to be the specified length.
            while (jsonA.size() > sizeLimit){
                jsonA.removeLast();
            }
            FileWriter file = new FileWriter(fileName);
            finalO.put("Highscores", jsonA);
            file.write(finalO.toJSONString());
            file.flush();
        } catch (IOException | ParseException e) {
            //If no entries exist, go into if Statement
            e.printStackTrace();
            b = true;
        }
        if (b){
            try {
                //write JSONObject into file as new JSON object
                FileWriter file = new FileWriter(fileName);
                jsonA.add(json);
                finalO.put("Highscores", jsonA);
                file.write(finalO.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Parse JSON file provided for a JSON object
    public JSONObject JSONFileParser() throws IOException, ParseException {
        FileReader reader = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        return (JSONObject)parser.parse(reader);
    }

    /**
     * Clears the entire Json file that is currently being used.
     */
    public void JSONFileClear(){
        try {
            FileWriter file = new FileWriter(fileName);
            file.write("");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return All the values as a Hashmap from the JSON file.
     */
    //IDE doesn't show warnings for "put" or "add" methods
    @SuppressWarnings("unchecked")
    public HashMap<String, Long> getValues(){
        //create return variable
        HashMap<String, Long> highscores = new HashMap<>();
        try {
            //try parsing file and putting all values into return variable;
            ArrayList<JSONObject> jsonA = new ArrayList<>();
            JSONArray jsonA1 = (JSONArray) JSONFileParser().get("Highscores");
            jsonA1.forEach(i -> jsonA.add((JSONObject) i));
            for (JSONObject json : jsonA){
                highscores.put((String) json.get("Name"), (Long)json.get("Score"));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return highscores;
    }

    /**
     * @return Get the name of the file in use.
     */
    public String getFileName() {
        return fileName;
    }
}
