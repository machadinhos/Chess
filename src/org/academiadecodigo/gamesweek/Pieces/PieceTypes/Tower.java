package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.TowerImage;

import java.util.List;

public class Tower extends Piece {
    private final TowerImage picture;
    private boolean asMoved;

    public Tower(Team team, Position position) {
        super(team, position);
        this.picture = new TowerImage(super.getCopy());
    }

    public TowerImage getPicture() {
        return picture;
    }

    public boolean asMoved() {
        return asMoved;
    }

    @Override
    public void move(Position newPosition) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (position.getCol() != super.getPosition().getCol() && position.getRow() != super.getPosition().getRow()) {
            return false;
        }


    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
