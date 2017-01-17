package ca.dantav.game.gfx;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ca.dantav.game.Game;

public final class GraphicManager  {

	public final List<GraphicHandler> graphics = new ArrayList<>();

	private Game game;
	
	public GraphicManager(Game game) {
		this.game = game;
	}
	
	public void drawAll(Graphics g) {
		graphics.stream().filter(Objects::nonNull).forEach((GraphicHandler h) -> h.draw(game, g));;
	}
	
	public void add(GraphicHandler handler) {
		graphics.add(handler);
	}
	
	public void remove(GraphicHandler handler) {
		graphics.remove(handler);
	}
	
	
	public Game getGame() {
		return game;
	}
	
}
