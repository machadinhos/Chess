package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.BishopImage;

import java.util.ArrayList;
import java.util.List;

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
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (super.getPosition().getCol() - super.getPosition().getRow() == position.getCol() - position.getRow()) {
            int col = super.getPosition().getCol();
            int row = super.getPosition().getRow();

            List<Piece> jointPieces = new ArrayList<>(whiteTeam);
            jointPieces.addAll(blackTeam);

            while (position.getCol() != col && position.getRow() != row) {
                if (col < position.getCol()) {
                    col += 1;
                } else if (col > position.getCol()) {
                    col -= 1;
                }
                if (row < position.getRow()) {
                    row += 1;
                } else if (row > position.getRow()) {
                    row -= 1;
                }

                for (Piece piece : jointPieces) {
                    if (piece.getPosition().getRow() == row && piece.getPosition().getCol() == col) {
                        if (col == position.getCol() && row == position.getRow()) {
                            return super.getTeam() != piece.getTeam();
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
