package ca.dantav.game.utility;

import java.util.Objects;

public final class ClassLoader<T> {
	
	private final String name;
	
	private T instance;
	
	public ClassLoader(String name) {
		this.name = name;
		this.instance = fetchInstance();
	}
	
	private final T fetchInstance() {
		T instance = null;
		try {
			instance = (T) Objects.requireNonNull(Class.forName(name).newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return instance;
	}
	
	
	public T getInstance() {
		return instance;
	}
	
	
	

}
