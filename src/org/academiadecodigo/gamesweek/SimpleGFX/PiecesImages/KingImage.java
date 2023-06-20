package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PieceImage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class KingImage extends PieceImage {

    private final Picture picture;

    public KingImage(Piece piece) {
        super(piece.getPosition());

        if (piece.getTeam() == Team.WHITE) {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/wK.png");
        } else {
            this.picture = new Picture(super.getxPosition(), getyPosition(), "resources/bK.png");
        }

        this.picture.draw();
    }

    @Override
    public Picture getPicture() {
        return this.picture;
    }

    @Override
    public void delete() {
        this.picture.delete();
    }

    public void updateImagePosition() {
        super.updateImagePosition(this.picture);
    }
}
