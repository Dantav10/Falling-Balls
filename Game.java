package ca.dantav.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import ca.dantav.game.entity.EntityManager;
import ca.dantav.game.entity.Player;
import ca.dantav.game.gfx.GraphicManager;
import ca.dantav.game.listener.KeyboardListener;
import ca.dantav.game.update.GameUpdateManager;
import ca.dantav.game.utility.JsonAttachable;
import ca.dantav.game.utility.attachable.AttachableManager;

@SuppressWarnings("serial")
public final class Game extends JPanel {
	
	private GraphicManager graphicManager = new GraphicManager(this);
	
	private Player player;
	
	private int ticks; 
	
	private final AttachableManager attachableManager = new AttachableManager();
	
	private GameUpdateManager gameUpdateManager = new GameUpdateManager(this);
	
	
	private EntityManager entityManager = new EntityManager();
	
	private boolean running;
	
	private Thread service;

	public Game() {
		this.setSize(GameConstants.GAME_WINDOW);
		this.setVisible(true);
		this.setFocusable(true);
		this.requestFocusInWindow();

		this.addKeyListener(new KeyboardListener(this));
		
		JsonAttachable json = new JsonAttachable();
		attachableManager.add(json);
		json.start();
		json.loadAll(this);
		
		start();
	}
	
	public void render() {
		repaint();
	}
	
	public void update() {
		gameUpdateManager.update();
		ticks++;
	}
	
	public void end() {
		this.running = false;
		this.entityManager.getEntities().clear();
		ticks = 0;
		repaint();
	}
	

	
	public void start() {
		this.running = true;
		this.service = new Thread(new GameService(this));
		
		service.start();
		
		this.player = new Player(this);
		
		entityManager.add(player);
		

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(running) {
			graphicManager.drawAll(g);
			return;
		}
		
		g.setColor(Color.RED);
		g.setFont(new Font("IMPACT", Font.BOLD, 46));
		g.drawString("YOU LOSE!", 210, 180);
		g.drawString("YOUR FINAL SCORE WAS " + player.getScore(), 80, 240);
		g.drawString("TYPE 'R' TO RESTART", 130, 300);

		
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public Thread getService() {
		return service;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public GraphicManager getGraphicManager() {
		return graphicManager;
	}
	
	public GameUpdateManager getGameUpdateManager() {
		return gameUpdateManager;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public AttachableManager getAttachableManager() {
		return attachableManager;
	}
	
	public int getTicks() {
		return ticks;
	}
	
	
}
