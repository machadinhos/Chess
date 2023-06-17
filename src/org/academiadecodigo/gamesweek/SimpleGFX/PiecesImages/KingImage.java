package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.King;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PieceImage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class KingImage extends PieceImage {

    private final Picture picture;

    public KingImage(King king) {
        super(king);

        if (king.getTeam() == Team.WHITE) {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/wK.png");
        } else {
            this.picture = new Picture(super.getxPosition(), getyPosition(), "resources/ChessPieces/bK.png");
        }

        this.picture.draw();
    }

    public void updateImagePosition() {
        super.updateImagePosition(this.picture);
    }
}
