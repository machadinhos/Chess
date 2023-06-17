package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.HorseImage;

public class Horse extends Piece {
    private final HorseImage picture;

    public Horse(Team team, Position position) {
        super(team, position);
        this.picture = new HorseImage(super.getCopy());
    }

    public HorseImage getPicture() {
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
