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
        if (position.getCol() - position.getRow() == 0) {
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
                } else if (col > position.getRow()) {
                    row -= 1;
                }

                for (Piece whitePiece : jointPieces) {
                    if (whitePiece.getPosition().getRow() == row && whitePiece.getPosition().getCol() == col) {
                        return super.getTeam() != whitePiece.getTeam();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<Position> getValidMoves() {
        throw new UnsupportedOperationException();
    }
}
