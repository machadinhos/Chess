package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.KingImage;

import java.util.List;

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

        return (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() == position.getRow()) ||
                (super.getPosition().getCol() == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) ||
                (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() == position.getRow()) ||
                (super.getPosition().getCol() == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) ||
                (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) ||
                (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) ||
                (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) ||
                (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow());
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
