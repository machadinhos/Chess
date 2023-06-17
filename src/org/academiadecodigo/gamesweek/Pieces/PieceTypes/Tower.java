package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.Position.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.TowerImage;

public class Tower extends Piece {
    private final TowerImage picture;

    public Tower(Team team, Position position) {
        super(team, position);
        this.picture = new TowerImage(super.getCopy());
    }

    public TowerImage getPicture() {
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
