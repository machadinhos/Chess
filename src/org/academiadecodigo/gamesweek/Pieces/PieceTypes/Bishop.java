package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.BishopImage;

public class Bishop extends Piece {
    private final BishopImage picture;

    public Bishop(Team team, Position position) {
        super(team, position);
        this.picture = new BishopImage(super.getCopy());
    }

    public BishopImage getPicture() {
        return picture;
    }

    @Override
    public void move(Position newPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove() {
        throw new UnsupportedOperationException();
    }
}
