package ca.dantav.game.entity;

import java.awt.Graphics;

import ca.dantav.game.Game;
import ca.dantav.game.Position;

public abstract class Entity {
	
	private Position position;
	
	private boolean destroy;
	
	private Game game;
	
	public Entity(Game game, Position position) {
		this.position = position;
		this.game = game;
	}
	
	public void destroy() {
		destroy = true;
	}
	
	
	public abstract void move();
	
	public abstract void draw(Graphics g);
	
	public boolean isDestroyed() {
		return destroy;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Game getGame() {
		return game;
	}
}
