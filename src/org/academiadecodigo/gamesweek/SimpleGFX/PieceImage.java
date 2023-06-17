package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.gamesweek.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class PieceImage {
    private final Position position;
    private int xPosition;
    private int yPosition;

    public PieceImage(Position position) {
        this.position = position;

        this.xPosition = position.getCol() * Field.SQUARESIZE + Field.PADDING;
        this.yPosition = position.getRow() * Field.SQUARESIZE + Field.PADDING;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void updateImagePosition(Picture picture) {
        int xPixelsMoved = position.getCol() * Field.SQUARESIZE - xPosition + Field.PADDING;
        int yPixelsMoved = position.getRow() * Field.SQUARESIZE - yPosition + Field.PADDING;

        picture.translate(xPixelsMoved, yPixelsMoved);

        this.xPosition = position.getCol() * Field.SQUARESIZE + Field.PADDING;
        this.yPosition = position.getRow() * Field.SQUARESIZE + Field.PADDING;
    }
}
