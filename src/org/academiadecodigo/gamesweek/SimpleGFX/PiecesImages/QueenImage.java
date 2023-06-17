package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Queen;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PieceImage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class QueenImage extends PieceImage {
    private final Picture picture;

    public QueenImage(Queen queen) {
        super(queen);

        if (queen.getTeam() == Team.WHITE) {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/wQ.png");
        } else {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/bQ.png");
        }

        this.picture.draw();
    }

    public void updateImagePosition() {
        super.updateImagePosition(this.picture);
    }
}
