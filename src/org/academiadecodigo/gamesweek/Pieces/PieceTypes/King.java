package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.KingImage;

public class King extends Piece {
    private final KingImage picture;

    public King(Team team, Position position) {
        super(team, position);
        this.picture = new KingImage(super.getCopy());
    }

    public KingImage getPicture() {
        return picture;
    }

    @Override
    public void move(Position newPosition) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove() {
        throw new UnsupportedOperationException();
    }
}
