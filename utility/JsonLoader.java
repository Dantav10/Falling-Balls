package ca.dantav.game.utility;

import java.io.FileReader;
import java.nio.file.Paths;

import ca.dantav.game.Game;
import ca.dantav.game.GameConstants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class JsonLoader {
	

    /**
     * The path to the {@code .json} file being parsed.
     */
    private final String path;
    

    /**
     * Creates a new {@link JsonLoader}.
     *
     * @param path
     *            the path to the {@code .json} file being parsed.
     */
    public JsonLoader(String path) {
        this.path = path;
    }


    /**
     * A dynamic method that allows the user to read and modify the parsed data.
     *
     * @param reader
     *            the reader for retrieving the parsed data.
     * @param builder
     *            the builder for retrieving the parsed data.
     */
    public abstract void load(Game game, JsonObject reader, Gson builder);

    /**
     * Loads the parsed data. How the data is loaded is defined by
     * {@link JsonLoader#load(JsonObject, Gson)}.
     *
     * @return the loader instance, for chaining.
     */
    public final JsonLoader load(Game game) {
        try (FileReader in = new FileReader(Paths.get(GameConstants.RESOURCE_PATH + path).toFile())) {
            JsonParser parser = new JsonParser();
            JsonArray array = (JsonArray) parser.parse(in);
            Gson builder = new GsonBuilder().create();

            for (int i = 0; i < array.size(); i++) {
                JsonObject reader = (JsonObject) array.get(i);
                load(game, reader, builder);
                
                if(i == array.size() - 1) {
                	destruct(game);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public void destruct(Game game) {
    	
    }
}


