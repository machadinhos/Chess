package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Bishop;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BishopImage {
    private final Picture picture;
    private final Bishop bishop;
    private int xPosition;
    private int yPosition;

    public BishopImage(Bishop bishop) {
        this.bishop = bishop;

        this.xPosition = bishop.getPosition().getRow() * Field.SQUARESIZE + Field.PADDING;
        this.yPosition = bishop.getPosition().getCol() * Field.SQUARESIZE + Field.PADDING;

        if (bishop.getTeam() == Team.WHITE) {
            this.picture = new Picture(xPosition, yPosition, "resources/ChessPieces/wB.png");
        } else {
            this.picture = new Picture(xPosition, yPosition, "resources/ChessPieces/bB.png");
        }
        this.picture.draw();
    }

    public void updateImagePosition () {
        int xPixelsMoved = xPosition - Field.PADDING - bishop.getPosition().getRow() * Field.SQUARESIZE;
        int yPixelsMoved = yPosition - Field.PADDING - bishop.getPosition().getCol() * Field.SQUARESIZE;

        this.picture.translate(xPixelsMoved, yPixelsMoved);

        this.xPosition += xPixelsMoved;
        this.yPosition += yPixelsMoved;
    }
}
