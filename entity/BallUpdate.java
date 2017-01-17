package ca.dantav.game.entity;

import ca.dantav.game.Game;
import ca.dantav.game.update.GameUpdate;

public final class BallUpdate implements GameUpdate {

	private int ticks = 10; 
	
	@Override
	public void update(Game game) {

		

		if(ticks <= 0) {
			game.getEntityManager().add(new Ball(game));
			ticks = 10;
			return;
		}
		
		int decreaseRate = 1 + (game.getTicks() / 50);
		
		if(decreaseRate >= 6) {
			decreaseRate = 5;
		}
		
		game.getPlayer().setBallSpeed(BallSpeed.forId(decreaseRate));
		ticks -= decreaseRate;
	}

}
