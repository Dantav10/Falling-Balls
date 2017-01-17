package ca.dantav.game;

import javax.swing.JFrame;

public final class GameApplet {

	public static void main(String[] args) {
		JFrame frame = new JFrame(GameConstants.GAME_NAME);
		Game game = new Game();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameConstants.GAME_WINDOW);
		frame.setResizable(false);
		frame.setVisible(true);
				
		
		frame.add(game);
	}
}
