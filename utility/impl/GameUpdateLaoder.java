package ca.dantav.game.utility.impl;

import ca.dantav.game.Game;
import ca.dantav.game.update.GameUpdate;
import ca.dantav.game.utility.ClassLoader;
import ca.dantav.game.utility.JsonLoader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public final class GameUpdateLaoder extends JsonLoader {

	public GameUpdateLaoder() {
		super("updates.json");
	}

	@Override
	public void load(Game game, JsonObject reader, Gson builder) {
		String name = reader.get("update").getAsString();
		
		ClassLoader<GameUpdate> loader = new ClassLoader<GameUpdate>(name);
		
		game.getGameUpdateManager().add(loader.getInstance());
		
	}

}