package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.PawnImage;

import java.util.ArrayList;
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
    public void move(Position newPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (!this.asMoved) {
            if (this.checkDoubleMove(position, whiteTeam, blackTeam)) {
                return true;
            }
        }

        if (super.getTeam() == Team.WHITE) {
            if (position.getRow() != super.getPosition().getRow() - 1) {
                return false;
            }
        } else {
            if (position.getRow() != super.getPosition().getRow() + 1) {
                return false;
            }
        }
        if (position.getCol() != super.getPosition().getCol() + 1 && position.getCol() != super.getPosition().getCol() - 1 && position.getCol() != super.getPosition().getCol()) {
            return false;
        }

        List<Piece> jointPieces = new ArrayList<>(whiteTeam);
        jointPieces.addAll(blackTeam);

        for (Piece piece : jointPieces) {
            if (piece.getPosition().getRow() == position.getRow()) {
                if (piece.getPosition().getCol() == position.getCol()) {
                    return false;
                } else if (piece.getPosition().getCol() == super.getPosition().getCol() + 1 || piece.getPosition().getCol() == super.getPosition().getCol() - 1) {
                    return piece.getTeam() != super.getTeam();
                }
            }
        }
        return true;
    }

    private boolean checkDoubleMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (super.getPosition().getCol() != position.getCol()) {
            return false;
        }
        if (super.getTeam() == Team.WHITE) {
            if (super.getPosition().getRow() - 2 != position.getRow()) {
                return false;
            }
        } else {
            if (super.getPosition().getRow() + 2 != position.getRow()) {
                return false;
            }
        }

        List<Piece> jointPieces = new ArrayList<>(whiteTeam);
        jointPieces.addAll(blackTeam);

        for (Piece piece : jointPieces) {
            if (piece.getPosition().equals(position)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
