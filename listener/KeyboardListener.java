package ca.dantav.game.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ca.dantav.game.Game;
import ca.dantav.game.entity.PlayerMovement;

public final class KeyboardListener implements KeyListener {
	
	private Game game;
	
	public KeyboardListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			game.getPlayer().setMovement(PlayerMovement.LEFT);
			break;
			
		case KeyEvent.VK_RIGHT:
			game.getPlayer().setMovement(PlayerMovement.RIGHT);
			break;
			
			
		case KeyEvent.VK_R:
			if(!game.isRunning()) {
				game.start();
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		game.getPlayer().setMovement(null);
	}

}
