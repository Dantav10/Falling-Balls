package ca.dantav.game.gfx.impl;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ca.dantav.game.Game;
import ca.dantav.game.entity.Entity;
import ca.dantav.game.gfx.GraphicHandler;

public final class EntityGraphics implements GraphicHandler {

	@Override
	public void draw(Game game, Graphics g) {
		List<Entity> entities = new ArrayList<>(game.getEntityManager().getEntities());
		entities.stream().filter(Objects::nonNull).forEach((Entity e) -> e.draw(g));
	}
	
}
