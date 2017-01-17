package ca.dantav.game.utility.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ca.dantav.game.Game;
import ca.dantav.game.utility.ClassLoader;
import ca.dantav.game.utility.JsonLoader;
import ca.dantav.game.utility.attachable.Attachable;

public final class AttachableLoader extends JsonLoader {

	public AttachableLoader() {
		super("attachables.json");
	}

	@Override
	public void load(Game game, JsonObject reader, Gson builder) {
		String name = reader.get("attachable").getAsString();
		
		ClassLoader<Attachable<?>> loader = new ClassLoader<Attachable<?>>(name);
		
		game.getAttachableManager().add(loader.getInstance());		
	}

}
