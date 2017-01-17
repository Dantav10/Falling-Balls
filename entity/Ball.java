package ca.dantav.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import ca.dantav.game.Boundary;
import ca.dantav.game.Game;
import ca.dantav.game.Position;

public final class Ball extends Entity {
	

	public Ball(Game game) {
		super(game, new Position(30 + new Random().nextInt(520), 10));
	}
	
	public void move() {
		
		if(getPosition().getY() > 400) {
			getGame().getPlayer().setScore(getGame().getPlayer().getScore() + 1);
			destroy();
			return;
		}
		
		Boundary boundary = new Boundary(getPosition().getX() - 50, getPosition().getX() + 50, getPosition().getY(), getPosition().getY() + 50);
		
		if(boundary.inArea(getGame().getPlayer().getPosition())) {
			getGame().end();
			return;
		}
		
		getPosition().move(0, 15);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(getPosition().getX(), getPosition().getY(), 50, 50);
	}
	
	

}
