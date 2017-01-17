package ca.dantav.game;

public final class Position {
	
	  /**
     * The {@code X} coordinate.
     */
    private int x;

    /**
     * The {@code Y} coordinate.
     */
    private int y;


    /**
     * Creates a new {@link Position} with the {@code Z} coordinate value as
     * {@code 0}.
     *
     * @param x
     *            the {@code X} coordinate.
     * @param y
     *            the {@code Y} coordinate.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "POSITION[x= " + x + ", y= " + y + "]";
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Position))
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
 
        return true;
    }

    
    public void move(int x, int y) {
    	this.x = this.x + x;
    	this.y = this.y + y;
    }
   

    /**
     * A substitute for {@link Object#clone()} that creates another 'copy' of
     * this instance. The created copy <i>safe</i> meaning it does not hold
     * <b>any</b> references to the original instance.
     *
     * @return the copy of this instance that does not hold any references.
     */
    @Override
    public Position clone() {
        return new Position(x, y);
    }


    /**
     * Determines if this position is within {@code amount} distance of
     * {@code other}.
     *
     * @param other
     *            the position to check the distance for.
     * @param amount
     *            the distance to check.
     * @return {@code true} if this position is within the distance,
     *         {@code false} otherwise.
     */
    public final boolean withinDistance(Position other, int amount) {
        return Math.abs(other.x - this.x) <= amount && Math.abs(other.y - this.y) <= amount;
    }


    /**
     * Gets the {@code X} coordinate.
     *
     * @return the {@code X} coordinate.
     */
    public final int getX() {
        return x;
    }

    /**
     * Sets the {@code X} coordinate.
     *
     * @param x
     *            the new {@code X} coordinate.
     */
    public final void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the {@code Y} coordinate.
     *
     * @return the {@code Y} coordinate.
     */
    public final int getY() {
        return y;
    }

    /**
     * Sets the {@code Y} coordinate.
     *
     * @param y
     *            the new {@code Y} coordinate.
     */
    public final void setY(int y) {
        this.y = y;
    }

}
