package ca.dantav.game.utility.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ca.dantav.game.Game;
import ca.dantav.game.gfx.GraphicHandler;
import ca.dantav.game.utility.JsonLoader;
import ca.dantav.game.utility.ClassLoader;

public final class GraphicsLoader extends JsonLoader {

	public GraphicsLoader() {
		super("graphics.json");
	}

	@Override
	public void load(Game game, JsonObject reader, Gson builder) {
		String name = reader.get("graphic").getAsString();
		
		ClassLoader<GraphicHandler> loader = new ClassLoader<GraphicHandler>(name);
		
		game.getGraphicManager().add(loader.getInstance());
		
	}

}
