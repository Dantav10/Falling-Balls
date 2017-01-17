package ca.dantav.game;


/**
 * Only works as a rectangle boundaries
 */
public class Boundary {
       
	/**
	 * gets the minimum X and maximum X of the square(opposites)
	 */
	private int minimumX, maximumX;
	
	/**
	 * gets the minimumY and maximumY of the square(opposites)
	 */
	private int minimumY, maximumY;
	
	public Boundary() {}
	/**
	 * Constructs the class
	 * @param minimumX
	 * @param maximumX
	 * @param minimumY
	 * @param maximumY
	 */
	public Boundary(int minimumX, int maximumX, int minimumY, int maximumY) {
		this.minimumX = minimumX;
		this.maximumX = maximumX;
		this.minimumY = minimumY;
		this.maximumY = maximumY;
	}
	
	/**
	 * Checks if the location is in the boundary
	 */
	public boolean inArea(Position position) {
		return position.getX() >= minimumX && position.getX() <= maximumX
			&& position.getY() >= minimumY && position.getY() <= maximumY;
	}
	
	/**
	 * @return minimumX
	 */
	public int getMinimumX() {
		return minimumX;
	}
	
	/**
	 * @return maximumX
	 */
	public int getMaximumX() {
		return maximumX;
	}
	
	/**
	 * @return minimumY
	 */
	public int getMinimumY() {
		return minimumY;
	}
	
	/**
	 * @return maximumY
	 */
	public int getMaximumY() {
		return maximumY;
	}
}