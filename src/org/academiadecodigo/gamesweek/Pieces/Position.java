package org.academiadecodigo.gamesweek.Pieces;

/**
 * This is a class that represents the position of a piece on the board with row and collum.
 */
public class Position {
	
	private int row;
	private int col;
	
	
	/**
	 * Contructs a piece position.
	 *
	 * @param row The row of the piece.
	 * @param col The collum of the piece.
	 */
	public Position (int row, int col) {
		
		this.row = row;
		this.col = col;
	}
	
	
	/**
	 * Update the position of a piece given the new row and collum.
	 *
	 * @param row The new row.
	 * @param col The new collum.
	 */
	public void setNewPosition (int row, int col) {
		
		this.row = row;
		this.col = col;
	}
	
	
	/**
	 * Compars the row and collum to determine if two positions are equal.
	 *
	 * @param position Position that will be compared.
	 *
	 * @return Boolean valeu that represents if the two positions are equal or not.
	 */
	public boolean equals (Position position) {
		
		return this.row == position.getRow() && this.col == position.getCol();
	}
	
	
	/**
	 * Returns the row of the position.
	 *
	 * @return The row of the position.
	 */
	public int getRow () {
		
		return row;
	}
	
	
	/**
	 * Returns the collum of the position.
	 *
	 * @return The collum of the position.
	 */
	public int getCol () {
		
		return col;
	}
	
	
	/**
	 * Returns a String representation of the position.
	 *
	 * @return The String representation of the position.
	 */
	@Override
	public String toString () {
		
		return "Position{" + "row=" + row + ", col=" + col + '}';
	}
	
}
