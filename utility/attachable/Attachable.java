package ca.dantav.game.utility.attachable;

import java.util.ArrayList;
import java.util.List;

import ca.dantav.game.Game;

public abstract class Attachable<T> {
	
	private final List<T> values = new ArrayList<>();
	
	private final String name;
	
	public Attachable(String name) {
		this.name = name;
	}
	
	public void loadAll(Game game) {
		values.stream().forEach((T t) -> load(game, t));
	}
	public abstract void load(Game game, T t);
	
	public abstract boolean add(T t);
	
	public abstract boolean remove(T t);
	
	public void clear() {
		values.clear();
	}
	
	public String getName() {
		return name;
	}
	
	public List<T> getValues() {
		return values;
	}
}
