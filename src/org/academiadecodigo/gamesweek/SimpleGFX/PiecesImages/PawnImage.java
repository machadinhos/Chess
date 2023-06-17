package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Pawn;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PieceImage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PawnImage extends PieceImage {

    private final Picture picture;

    public PawnImage(Pawn pawn) {
        super(pawn);

        if (pawn.getTeam() == Team.WHITE) {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/wP.png");
        } else {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/bP.png");
        }

        this.picture.draw();
    }

    public void updateImagePosition() {
        super.updateImagePosition(this.picture);
    }
}
