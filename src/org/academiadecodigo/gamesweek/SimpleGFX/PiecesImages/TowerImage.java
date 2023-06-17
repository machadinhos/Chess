package org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Tower;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PieceImage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TowerImage extends PieceImage {
    private final Picture picture;

    public TowerImage(Tower tower) {
        super(tower);

        if (tower.getTeam() == Team.WHITE) {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/wR.png");
        } else {
            this.picture = new Picture(super.getxPosition(), super.getyPosition(), "resources/ChessPieces/bR.png");
        }

        this.picture.draw();
    }

    public void updateImagePosition() {
        super.updateImagePosition(this.picture);
    }

}
