package ca.dantav.game.gfx.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ca.dantav.game.Game;
import ca.dantav.game.gfx.GraphicHandler;

public final class DebugGraphics implements GraphicHandler {

	@Override
	public void draw(Game game, Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Impact", Font.BOLD, 16));
		g.drawString("Score: " + game.getPlayer().getScore(), 5, 20);
		g.drawString("Speed: " + game.getPlayer().getSpeed().getDescription(), 5, 40);

	}

}
