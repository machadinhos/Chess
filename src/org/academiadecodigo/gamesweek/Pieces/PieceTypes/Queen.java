package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.QueenImage;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    private QueenImage picture;

    public Queen(Team team, Position position) {
        super(team, position);
    }

    public void initImage() {
        this.picture = new QueenImage(super.getCopy());
    }

    @Override
    public void move(Position newPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (Math.abs(super.getPosition().getCol() - position.getCol()) != Math.abs(super.getPosition().getRow() - position.getRow())) {
            if (position.getCol() != super.getPosition().getCol() && position.getRow() != super.getPosition().getRow()) {
                return false;
            }
        }

        int col = super.getPosition().getCol();
        int row = super.getPosition().getRow();

        List<Piece> jointPieces = new ArrayList<>(whiteTeam);
        jointPieces.addAll(blackTeam);

        if (Math.abs(col - position.getCol()) == Math.abs(row - position.getRow())) {
            while (position.getCol() != col && position.getRow() != row) {
                if (col < position.getCol()) {
                    col++;
                } else if (col > position.getCol()) {
                    col--;
                }
                if (row < position.getRow()) {
                    row++;
                } else if (row > position.getRow()) {
                    row--;
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
        } else if (position.getCol() == super.getPosition().getCol() ^ position.getRow() == super.getPosition().getRow()) {
            while (position.getCol() != col || position.getRow() != row) {
                if (position.getCol() == super.getPosition().getCol()) {
                    if (row < position.getRow()) {
                        row++;
                    } else if (row > position.getRow()) {
                        row--;
                    }
                } else {
                    if (col < position.getCol()) {
                        col++;
                    } else if (col > position.getCol()) {
                        col--;
                    }
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
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<Position> getValidMoves(List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition) {
        throw new UnsupportedOperationException();
    }

    public QueenImage getPicture() {
        return picture;
    }
}
