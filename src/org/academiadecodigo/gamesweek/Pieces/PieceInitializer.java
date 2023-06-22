package org.academiadecodigo.gamesweek.Pieces;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class initializes the white and black team.
 */
public class PieceInitializer {
	
	/**
	 * This method builds the white team and returns a list of its pieces.
	 *
	 * @return The list contains the white team pieces.
	 */
	public static List<Piece> initWhitePieces () {
		
		List<Piece> pieces = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			pieces.add(new Pawn(Team.WHITE, new Position(6, i)));
		}
		
		pieces.add(new Tower(Team.WHITE, new Position(7, 0)));
		pieces.add(new Tower(Team.WHITE, new Position(7, 7)));
		
		pieces.add(new Horse(Team.WHITE, new Position(7, 1)));
		pieces.add(new Horse(Team.WHITE, new Position(7, 6)));
		
		pieces.add(new Bishop(Team.WHITE, new Position(7, 2)));
		pieces.add(new Bishop(Team.WHITE, new Position(7, 5)));
		
		pieces.add(new Queen(Team.WHITE, new Position(7, 3)));
		pieces.add(new King(Team.WHITE, new Position(7, 4)));
		
		return pieces;
	}
	
	
	/**
	 * This method builds the black team and returns a list of its pieces.
	 *
	 * @return The list contains the black team pieces.
	 */
	public static List<Piece> initBlackPieces () {
		
		List<Piece> pieces = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			pieces.add(new Pawn(Team.BLACK, new Position(1, i)));
		}
		
		pieces.add(new Tower(Team.BLACK, new Position(0, 0)));
		pieces.add(new Tower(Team.BLACK, new Position(0, 7)));
		
		pieces.add(new Horse(Team.BLACK, new Position(0, 1)));
		pieces.add(new Horse(Team.BLACK, new Position(0, 6)));
		
		pieces.add(new Bishop(Team.BLACK, new Position(0, 2)));
		pieces.add(new Bishop(Team.BLACK, new Position(0, 5)));
		
		pieces.add(new Queen(Team.BLACK, new Position(0, 3)));
		pieces.add(new King(Team.BLACK, new Position(0, 4)));
		
		return pieces;
	}
	
	
	/**
	 * This method initializes the Picture of each piece of each team.
	 *
	 * @param whitePices  The list of white pieces.
	 * @param blackPieces The list of black pieces.
	 */
	public static void initImages (List<Piece> whitePices, List<Piece> blackPieces) {
		
		for (Piece piece : whitePices) {
			piece.initImage();
		}
		
		for (Piece piece : blackPieces) {
			piece.initImage();
		}
	}
	
}
