package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.HorseImage;

import java.util.List;

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
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        List<Piece> piecesSameTeam;
        if (super.getTeam() == Team.WHITE) {
            piecesSameTeam = whiteTeam;
        } else {
            piecesSameTeam = blackTeam;
        }

        for (Piece piece : piecesSameTeam) {
            if (position.getRow() == piece.getPosition().getRow() && position.getCol() == piece.getPosition().getCol()) {
                return false;
            }
        }

        return (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() + 2 == position.getRow()) ||
                (super.getPosition().getCol() + 2 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) ||
                (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() + 2 == position.getRow()) ||
                (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() - 2 == position.getRow()) ||
                (super.getPosition().getCol() - 2 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) ||
                (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() - 2 == position.getRow()) ||
                (super.getPosition().getCol() + 2 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) ||
                (super.getPosition().getCol() - 2 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow());
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
