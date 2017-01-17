package ca.dantav.game.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public final class EntityManager {
	
	private List<Entity> entities = new ArrayList<Entity>();
	

	public EntityManager() {
		
	}
	
	public void update() {
		
			new ArrayList<>(entities).stream().filter(Objects::nonNull).forEach(new Consumer<Entity>() {

			@Override
			public void accept(Entity entity) {

				if(entity.isDestroyed()) {
					remove(entity);
					return;
				}
				
				entity.move();
			}
			
		});
	}
	
	public void add(Entity entity) {
		entities.add(entity);
	}
	
	public void remove(Entity entity) {
		entities.remove(entity);
	}
	
	public List<Entity> getEntities() {
		return entities;
	}

}
