package ca.dantav.game.utility;

import ca.dantav.game.Game;
import ca.dantav.game.utility.attachable.Attachable;
import ca.dantav.game.utility.impl.AttachableLoader;
import ca.dantav.game.utility.impl.GameUpdateLaoder;
import ca.dantav.game.utility.impl.GraphicsLoader;


public final class JsonAttachable extends Attachable<JsonLoader> {

	public JsonAttachable() {
		super("json");
	}

	public void start() {
		add(new AttachableLoader());
		add(new GameUpdateLaoder());
		add(new GraphicsLoader());
	}

	@Override
	public boolean add(JsonLoader t) {
		return getValues().add(t);
	}

	@Override
	public boolean remove(JsonLoader t) {
		return getValues().remove(t);
	}


	@Override
	public void load(Game game, JsonLoader t) {
		t.load(game);
	}


}
