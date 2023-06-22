package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.*;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	public static final int SQUARESIZE = 90;
	public static final int PADDING = 10;
	public static final int BOARDSIZE = SQUARESIZE * 8;
	private static final int VALIDMOVESRADIUS = 45;
	private static final int VALIDMOVEENEMYSRADIUS = 20;
	private static final Rectangle[][] boardSquares = new Rectangle[8][8];
	private static List<Ellipse> validMovesEllipse;
	private static List<Position> validMovesPositions;
	private static List<Movable> selectAPieceMenu;
	
	
	public static void init () {
		
		int xPosition = PADDING;
		int yPosition = PADDING;
		Color color = Color.WHITE;
		
		Rectangle border = new Rectangle(PADDING - 1, PADDING - 1, SQUARESIZE * 8 + 1, SQUARESIZE * 8 + 1);
		
		border.draw();
		
		for (int row = 0; row < boardSquares.length; row++) {
			for (int square = 0; square < boardSquares[row].length; square++) {
				boardSquares[row][square] = new Rectangle(xPosition, yPosition, SQUARESIZE, SQUARESIZE);
				boardSquares[row][square].setColor(color);
				boardSquares[row][square].fill();
				
				if (color.equals(Color.WHITE)) {
					color = Color.BLACK;
				} else {
					color = Color.WHITE;
				}
				xPosition += SQUARESIZE;
			}
			
			if (color.equals(Color.WHITE)) {
				color = Color.BLACK;
			} else {
				color = Color.WHITE;
			}
			
			xPosition = PADDING;
			yPosition += SQUARESIZE;
		}
		
		createLabels();
	}
	
	
	private static void createLabels () {
		
		Text letterA = new Text(Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "a");
		letterA.setColor(Color.WHITE);
		letterA.grow(4, 8);
		letterA.draw();
		
		Text letterB = new Text(2 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "b");
		letterB.setColor(Color.BLACK);
		letterB.grow(4, 8);
		letterB.draw();
		
		
		Text letterC = new Text(3 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "c");
		letterC.setColor(Color.WHITE);
		letterC.grow(4, 8);
		letterC.draw();
		
		
		Text letterD = new Text(4 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "d");
		letterD.setColor(Color.BLACK);
		letterD.grow(4, 8);
		letterD.draw();
		
		
		Text letterE = new Text(5 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "e");
		letterE.setColor(Color.WHITE);
		letterE.grow(4, 8);
		letterE.draw();
		
		
		Text letterF = new Text(6 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "f");
		letterF.setColor(Color.BLACK);
		letterF.grow(4, 8);
		letterF.draw();
		
		
		Text letterG = new Text(7 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - 14, "g");
		letterG.setColor(Color.WHITE);
		letterG.grow(4, 8);
		letterG.draw();
		
		
		Text letterH = new Text(8 * Board.SQUARESIZE - 2, 8 * Board.SQUARESIZE - Board.PADDING, "h");
		letterH.setColor(Color.BLACK);
		letterH.grow(4, 8);
		letterH.draw();
		
		
		Text letter1 = new Text(Board.PADDING + 5, 7 * Board.SQUARESIZE + Board.PADDING + 4, "1");
		letter1.setColor(Color.WHITE);
		letter1.grow(4, 8);
		letter1.draw();
		
		
		Text letter2 = new Text(Board.PADDING + 5, 6 * Board.SQUARESIZE + Board.PADDING + 4, "2");
		letter2.setColor(Color.BLACK);
		letter2.grow(4, 8);
		letter2.draw();
		
		
		Text letter3 = new Text(Board.PADDING + 5, 5 * Board.SQUARESIZE + Board.PADDING + 4, "3");
		letter3.setColor(Color.WHITE);
		letter3.grow(4, 8);
		letter3.draw();
		
		
		Text letter4 = new Text(Board.PADDING + 5, 4 * Board.SQUARESIZE + Board.PADDING + 4, "4");
		letter4.setColor(Color.BLACK);
		letter4.grow(4, 8);
		letter4.draw();
		
		
		Text letter5 = new Text(Board.PADDING + 5, 3 * Board.SQUARESIZE + Board.PADDING + 4, "5");
		letter5.setColor(Color.WHITE);
		letter5.grow(4, 8);
		letter5.draw();
		
		
		Text letter6 = new Text(Board.PADDING + 5, 2 * Board.SQUARESIZE + Board.PADDING + 4, "6");
		letter6.setColor(Color.BLACK);
		letter6.grow(4, 8);
		letter6.draw();
		
		
		Text letter7 = new Text(Board.PADDING + 5, Board.SQUARESIZE + Board.PADDING + 4, "7");
		letter7.setColor(Color.WHITE);
		letter7.grow(4, 8);
		letter7.draw();
		
		
		Text letter8 = new Text(Board.PADDING + 5, Board.PADDING + 4, "8");
		letter8.setColor(Color.BLACK);
		letter8.grow(4, 8);
		letter8.draw();
	}
	
	
	public static List<Ellipse> getValidMovesEllipse () {
		
		return validMovesEllipse;
	}
	
	
	public static List<Position> getValidMovesPositions () {
		
		return validMovesPositions;
	}
	
	
	public static void showValidMoves (List<Position> validMoves, List<Piece> enemyTeam) {
		
		Board.validMovesEllipse = new ArrayList<>();
		Board.validMovesPositions = new ArrayList<>();
		
		Ellipse circle;
		
		for (Position move : validMoves) {
			boolean hasEnemy = false;
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(move)) {
					System.out.println(enemy);
					
					hasEnemy = true;
					break;
				}
			}
			
			if (hasEnemy) {
				circle = new Ellipse(positionToPixel(move)[0] + (double) SQUARESIZE / 2 - (double) VALIDMOVEENEMYSRADIUS / 2, positionToPixel(move)[1] + (double) SQUARESIZE / 2 - (double) VALIDMOVEENEMYSRADIUS / 2, VALIDMOVEENEMYSRADIUS, VALIDMOVEENEMYSRADIUS);
				circle.setColor(Color.RED);
				circle.fill();
			} else {
				circle = new Ellipse(positionToPixel(move)[0] + (double) VALIDMOVESRADIUS / 2, positionToPixel(move)[1] + (double) VALIDMOVESRADIUS / 2, VALIDMOVESRADIUS, VALIDMOVESRADIUS);
				circle.setColor(Color.LIGHT_GRAY);
				circle.fill();
			}
			
			Board.validMovesEllipse.add(circle);
			Board.validMovesPositions.add(move);
		}
	}
	
	
	public static int[] positionToPixel (Position position) {
		
		return new int[]{position.getCol() * Board.SQUARESIZE + Board.PADDING, position.getRow() * Board.SQUARESIZE + Board.PADDING};
	}
	
	
	public static void hideValidMoves () {
		
		if (validMovesEllipse != null) {
			for (Ellipse move : validMovesEllipse) {
				move.delete();
			}
			validMovesEllipse = null;
			validMovesPositions = null;
		}
	}
	
	
	public static List<Piece> showSelectAPieceMenu (List<Piece> piecesToChoseFrom) {
		
		if (Board.selectAPieceMenu == null) {
			Board.selectAPieceMenu = new ArrayList<>();
		}
		List<Piece> pieces = new ArrayList<>();
		
		Rectangle rectangle = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
		Rectangle rectangle2 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
		
		Board.selectAPieceMenu.add(rectangle2);
		Board.selectAPieceMenu.add(rectangle);
		
		rectangle.setColor(Color.WHITE);
		rectangle.fill();
		
		rectangle2.setColor(Color.BLACK);
		rectangle2.draw();
		
		List<Piece> validPieces = new ArrayList<>();
		boolean alreadyExists;
		
		for (Piece piecesKilled : piecesToChoseFrom) {
			alreadyExists = false;
			for (Piece piece : validPieces) {
				if (piecesKilled.getClass() == piece.getClass()) {
					alreadyExists = true;
					break;
				}
			}
			
			if (!alreadyExists) {
				validPieces.add(piecesKilled);
			}
		}
		
		int col = 2;
		
		for (Piece piece : validPieces) {
			if (!(piece instanceof Pawn)) {
				piece.initImage();
				piece.move(4, col);
				pieces.add(piece);
				col++;
				if (piece instanceof Queen queen) {
					Board.selectAPieceMenu.add(queen.getPicture().getPicture());
				} else if (piece instanceof Tower tower) {
					Board.selectAPieceMenu.add(tower.getPicture().getPicture());
				} else if (piece instanceof Bishop bishop) {
					Board.selectAPieceMenu.add(bishop.getPicture().getPicture());
				} else if (piece instanceof Horse horse) {
					Board.selectAPieceMenu.add(horse.getPicture().getPicture());
				}
			}
		}
		return pieces;
	}
	
	
	public static void hideSelectAPieceMenu () {
		
		if (Board.selectAPieceMenu == null) {
			return;
		}
		for (Movable thing : Board.selectAPieceMenu) {
			if (thing instanceof Rectangle rectangle) {
				rectangle.delete();
			} else if (thing instanceof Picture picture) {
				picture.delete();
			}
		}
		Board.selectAPieceMenu = null;
	}
	
	
	public static Position pixelToPosition (int x, int y) {
		
		return new Position((y - 40) / Board.SQUARESIZE, (x - 20) / Board.SQUARESIZE);
	}
	
}
