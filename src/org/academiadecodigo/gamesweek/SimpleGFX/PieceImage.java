package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class PieceImage {
	
	private final Position position;
	private int xPosition;
	private int yPosition;
	
	
	public PieceImage (Position position) {
		
		this.position = position;
		
		this.xPosition = position.getCol() * Board.SQUARESIZE + Board.PADDING;
		this.yPosition = position.getRow() * Board.SQUARESIZE + Board.PADDING;
	}
	
	
	public int getxPosition () {
		
		return xPosition;
	}
	
	
	public int getyPosition () {
		
		return yPosition;
	}
	
	
	public void updateImagePosition (Picture picture) {
		
		int xPixelsMoved = position.getCol() * Board.SQUARESIZE - xPosition + Board.PADDING;
		int yPixelsMoved = position.getRow() * Board.SQUARESIZE - yPosition + Board.PADDING;
		
		picture.translate(xPixelsMoved, yPixelsMoved);
		
		this.xPosition = position.getCol() * Board.SQUARESIZE + Board.PADDING;
		this.yPosition = position.getRow() * Board.SQUARESIZE + Board.PADDING;
	}
	
	
	public abstract Picture getPicture ();
	
	
	public abstract void delete ();
	
}
