package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.PawnImage;

import java.util.List;

public class Pawn extends Piece {
    private final PawnImage picture;
    private boolean asMoved;

    public Pawn(Team team, Position position) {
        super(team, position);
        this.picture = new PawnImage(super.getCopy());
    }

    public PawnImage getPicture() {
        return picture;
    }

    @Override
    public void move(Position newPosition) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
