package ca.dantav.game.entity;

public enum PlayerMovement {

	RIGHT(30) {
		
		@Override
		public boolean canMove(Player player) {
			return player.getPosition().getX() <= 530;
		}
	},
	
	LEFT(-30) {
		
		@Override
		public boolean canMove(Player player) {
			return player.getPosition().getX() >= 40;
		}
	};
	
	private int offset;
	
	private PlayerMovement(int offset) {
		this.offset = offset;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public abstract boolean canMove(Player player);
}
