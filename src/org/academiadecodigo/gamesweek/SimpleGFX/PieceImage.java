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

        this.xPosition = piece.getPosition().getCol() * Field.SQUARESIZE + Field.PADDING;
        this.yPosition = piece.getPosition().getRow() * Field.SQUARESIZE + Field.PADDING;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void updateImagePosition (Picture picture) {
        int xPixelsMoved = piece.getPosition().getCol() * Field.SQUARESIZE - xPosition + Field.PADDING;
        int yPixelsMoved = piece.getPosition().getRow() * Field.SQUARESIZE - yPosition + Field.PADDING;

        System.out.println(xPixelsMoved);
        System.out.println(yPixelsMoved);

        picture.translate(xPixelsMoved, yPixelsMoved);

        this.xPosition = piece.getPosition().getCol() * Field.SQUARESIZE + Field.PADDING;
        this.yPosition = piece.getPosition().getRow() * Field.SQUARESIZE + Field.PADDING;
    }
}
