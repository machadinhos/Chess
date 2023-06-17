package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class PieceImage {
    private final Piece piece;
    private int xPosition;
    private int yPosition;

    public PieceImage(Piece piece) {
        this.piece = piece;

        this.xPosition = piece.getPosition().getRow() * Field.SQUARESIZE + Field.PADDING;
        this.yPosition = piece.getPosition().getCol() * Field.SQUARESIZE + Field.PADDING;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void updateImagePosition (Picture picture) {
        int xPixelsMoved = xPosition - Field.PADDING - piece.getPosition().getRow() * Field.SQUARESIZE;
        int yPixelsMoved = yPosition - Field.PADDING - piece.getPosition().getCol() * Field.SQUARESIZE;

        picture.translate(xPixelsMoved, yPixelsMoved);

        this.xPosition += xPixelsMoved;
        this.yPosition += yPixelsMoved;
    }
}
