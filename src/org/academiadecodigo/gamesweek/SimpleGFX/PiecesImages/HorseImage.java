package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PieceImage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HorseImage extends PieceImage {
	
	private final Picture picture;
	
	
	public HorseImage (Piece piece) {
		
		super(piece.getPosition());
		
		if (piece.getTeam() == Team.WHITE) {
			this.picture = new Picture(super.getxPosition(), super.getyPosition(), "wN.png");
		} else {
			this.picture = new Picture(super.getxPosition(), super.getyPosition(), "bN.png");
		}
		
		this.picture.draw();
	}
	
	
	@Override
	public Picture getPicture () {
		
		return this.picture;
	}
	
	
	@Override
	public void delete () {
		
		this.picture.delete();
	}
	
	
	public void updateImagePosition () {
		
		super.updateImagePosition(this.picture);
	}
	
}
