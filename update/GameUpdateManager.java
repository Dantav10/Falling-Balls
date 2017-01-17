package ca.dantav.game.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ca.dantav.game.Game;

public final class GameUpdateManager {

	private List<GameUpdate> updates = new ArrayList<>();
	
	private final Game game;
	
	public GameUpdateManager(Game game) {
		this.game = game;
	}
	
	public void update() {
		updates.stream().filter(Objects::nonNull).forEach((GameUpdate u) -> u.update(game));
	}
	
	public void add(GameUpdate update) {
		updates.add(update);
	}
	
	public void remove(GameUpdate update) {
		updates.remove(update);
	}
}
