package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.KingImage;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private final KingImage picture;
    private boolean asMoved;

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
        if (!this.asMoved) {
            if (this.checkRook(position, whiteTeam, blackTeam)) {
                return true;
            }
        }

        List<Piece> piecesSameTeam;
        if (super.getTeam() == Team.WHITE) {
            piecesSameTeam = whiteTeam;
        } else {
            piecesSameTeam = blackTeam;
        }

        for (Piece piece : piecesSameTeam) {
            if (piece.getPosition().equals(position)) {
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

    private boolean checkRook(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (super.getPosition().getRow() == position.getRow()) {
            if (position.getCol() == super.getPosition().getCol() - 2 || position.getCol() == super.getPosition().getCol() + 2) {
                List<Piece> sameTeam;
                int towerNum = 0;

                if (super.getTeam() == Team.WHITE) {
                    sameTeam = whiteTeam;
                } else {
                    sameTeam = blackTeam;
                }

                for (Piece piece : sameTeam) {
                    if (piece instanceof Tower tower) {
                        if (!tower.asMoved()) {
                            towerNum++;
                        }
                    }
                }

                if (towerNum == 0) {
                    return false;
                }

                List<Piece> jointPieces = new ArrayList<>(whiteTeam);
                jointPieces.addAll(blackTeam);

                for (Piece piece : jointPieces) {
                    if (piece.getPosition().getRow() == super.getPosition().getRow()) {
                        if (super.getPosition().getCol() < position.getCol()) {
                            if (piece.getPosition().getCol() == 6 || piece.getPosition().getCol() == 5) {
                                return false;
                            }
                        } else {
                            if (piece.getPosition().getCol() == 1 || piece.getPosition().getCol() == 2 || piece.getPosition().getCol() == 3) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
