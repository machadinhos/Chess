package org.academiadecodigo.gamesweek.Pieces;

import java.util.List;

/**
 * This is an abstract class that represnts a generic chess piece.
 * It provides common properties and methods for all chess pieces.
 */
public abstract class Piece {
	
	private final Team team;
	private final Position position;
	
	
	/**
	 * Contrutcts a chess piece given his team and position.
	 *
	 * @param team     The team of the piece.
	 * @param position The position of the piece.
	 */
	public Piece (Team team, Position position) {
		
		this.team = team;
		this.position = position;
	}
	
	
	/**
	 * Initializes the piece picture
	 */
	public abstract void initImage ();
	
	
	/**
	 * Returns her self.
	 *
	 * @return Her self.
	 */
	public Piece getCopy () {
		
		return this;
	}
	
	
	/**
	 * Returns the team of the piece.
	 *
	 * @return The team of the piece.
	 */
	public Team getTeam () {
		
		return team;
	}
	
	
	/**
	 * Updates the piece position give the new row and collum.
	 *
	 * @param row The new row.
	 * @param col The new collum.
	 */
	public void move (int row, int col) {
		
		this.position.setNewPosition(row, col);
	}
	
	
	/**
	 * Checks if the piece can move to the given target position.
	 * Doesn't take into account if the king is in risk.
	 *
	 * @param position  The target position.
	 * @param whiteTeam The list of the white team pieces.
	 * @param blackTeam The list of the black team pieces.
	 *
	 * @return The boolean that represents if the move is possible or not.
	 */
	public abstract boolean checkValidMove (Position position, List<Piece> whiteTeam, List<Piece> blackTeam);
	
	
	/**
	 * Returns a list that contains all the possible moves positions of the piece.
	 * Takes into account if the king is in risk.
	 *
	 * @param whiteTeam         The list of the white team pieces.
	 * @param blackTeam         The list of the black team pieces.
	 * @param whiteKingPosition The position of the white king.
	 * @param blackKingPosition The position of the black king.
	 *
	 * @return The list of the positions of the possible moves.
	 */
	public abstract List<Position> getValidMoves (List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition);
	
	
	/**
	 * Hides the picture that represents the piece on the board.
	 */
	public abstract void die ();
	
	
	/**
	 * Returns a String representation of the piece.
	 *
	 * @return The String representation of the piece.
	 */
	@Override
	public abstract String toString ();
	
	
	/**
	 * Return the current position of the piece.
	 *
	 * @return The position of the piece.
	 */
	public Position getPosition () {
		
		return position;
	}
	
}
