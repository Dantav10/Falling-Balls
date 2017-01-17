package ca.dantav.game.entity;

import java.util.Arrays;
import java.util.function.Predicate;

public enum BallSpeed {
	
	VERY_SLOW(1, "VERY SLOW"),
	SLOW(2, "SLOW"),
	MEDIUM(3, "GETTING FAST"),
	FAST(4, "FAST"),
	SUPER_FAST(5, "IMPOSSIBLE");
	
	private int decreaseRate;
	private String description;
	
	BallSpeed(int decreaseRate, String description) {
		this.decreaseRate = decreaseRate;
		this.description = description;
	}
	
	public static final BallSpeed forId(int decreaseRate) {
		Predicate<BallSpeed> rate = (BallSpeed b) -> b.getDecreaseRate() == decreaseRate;
		return Arrays.stream(values()).filter(rate).findFirst().get();
	}
	
	public int getDecreaseRate() {
		return decreaseRate;
	}
	
	public String getDescription() {
		return description;
	}

}
