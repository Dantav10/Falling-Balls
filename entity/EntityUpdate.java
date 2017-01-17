package ca.dantav.game.entity;

import ca.dantav.game.Game;
import ca.dantav.game.update.GameUpdate;

public final class EntityUpdate implements GameUpdate {

	@Override
	public void update(Game game) {
		game.getEntityManager().update();
	}

}
