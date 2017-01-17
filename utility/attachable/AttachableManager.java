package ca.dantav.game.utility.attachable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import ca.dantav.game.utility.JsonAttachable;

public final class AttachableManager {
	
	private final Map<String, Attachable<?>> attachables = new HashMap<>();

	
	public AttachableManager() {
	}
	
	public void load() {
		
	}
	
	public boolean add(Attachable<?> t) {
		Optional<Attachable<?>> attachable = Optional.ofNullable(t);
		
		if(attachable.isPresent()) {
			attachables.put(t.getName(), t);
			return true;
		}
		
		return false;
	}
	
	public <T> boolean remove(String name) {
		if(attachables.containsKey(name)) {
			Optional<Attachable<T>> attachable = get(name);
			
			if(attachable.isPresent()) {
				return attachables.remove(name, attachable.get());
			}
			
			return false;
		}
		
		return false;
	}
	
	
	public <T> Optional<Attachable<T>> get(String name) {
		if(attachables.containsKey(name)) {
			
			Attachable<T> attachable = (Attachable<T>) attachables.get(name);
			
			Optional<Attachable<T>> optionalAttachable = Optional.ofNullable(attachable);
			
			return optionalAttachable;
		}
		
		return Optional.empty();
	}
	
}
