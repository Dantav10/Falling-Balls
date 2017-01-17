package ca.dantav.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Optional;

import ca.dantav.game.Game;
import ca.dantav.game.Position;

public final class Player extends Entity {

	private PlayerMovement movement;
	
	private BallSpeed speed = BallSpeed.VERY_SLOW;
	
	private int score;
	
	public Player(Game game) {
		super(game, new Position(250, 326));
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getPosition().getX(), getPosition().getY(), 50, 50);
	}

	@Override
	public void move() {
		Optional<PlayerMovement> movement = Optional.ofNullable(this.movement);
		

		if(movement.isPresent() && movement.get().canMove(this)) {
			getPosition().move(movement.get().getOffset(), 0);
			return;
		}
		
	}
	
	public PlayerMovement getMovement() {
		return movement;
	}
	
	public void setMovement(PlayerMovement movement) {
		this.movement = movement;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public BallSpeed getSpeed() {
		return speed;
	}
	
	public void setBallSpeed(BallSpeed speed) {
		this.speed = speed;
	}

}
