package main.ch.IP12.prototype.scoreBoard;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataDealer {
    //variable for easy access to file
    private String fileName;
    private final int sizeLimit;

    public DataDealer(String fileName) throws IOException {
        this(fileName, 10);
    }

    public DataDealer(String fileName, int BoardSizeLimit) throws IOException {
        //check for file existence and creation if it doesn't
        boolean b;
        sizeLimit = BoardSizeLimit;
        setFileName(fileName);
        File f = new File(fileName);
        if(!f.exists()){
            b = f.createNewFile();
            assert b;
        }
        assert f.isFile();
    }

    //IDE doesn't show warnings for "put" or "add" methods
    @SuppressWarnings("unchecked")
    //write score and datetime to JSON file
    public void dataStore(String name, long Score){
        //create variables for JSON and content writing functionality
        boolean b = false;
        JSONObject json = new JSONObject();
        JSONObject finalO = new JSONObject();
        JSONArray jsonA = new JSONArray();

        //add values to JSON Object
        json.put("Name", name);
        json.put("Score", Score);

        //write to file if it has entries already
        try {
            //add existing entries to JSON Array and write into file as new JSON object
            jsonA.addAll((JSONArray) JSONFileParser().get("Highscores"));
            jsonA.add(json);
            while (jsonA.size() > sizeLimit){
                jsonA.removeLast();
            }
            FileWriter file = new FileWriter(fileName);
            finalO.put("Highscores", jsonA);
            file.write(finalO.toJSONString());
            file.flush();
        } catch (IOException | ParseException e) {
            //if no Entries exist, go into if Statement
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

    //clear entire JSON file
    public void JSONFileClear(){
        try {
            FileWriter file = new FileWriter(fileName);
            file.write("");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //IDE doesn't show warnings for "put" or "add" methods
    @SuppressWarnings("unchecked")
    //Get all values from JSON file
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

    //get set for the file's name
    public String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
