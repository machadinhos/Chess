package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.TowerImage;

import java.util.ArrayList;
import java.util.List;

public class Tower extends Piece {
    private TowerImage picture;
    private boolean asMoved;

    public Tower(Team team, Position position) {
        super(team, position);
    }

    public void initImage() {
        this.picture = new TowerImage(super.getCopy());
    }

    @Override
    public void move(int row, int col) {
        super.move(row, col);
        this.picture.updateImagePosition();
    }

    @Override
    public boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
        if (position.getCol() != super.getPosition().getCol() && position.getRow() != super.getPosition().getRow()) {
            return false;
        }

        int col = super.getPosition().getCol();
        int row = super.getPosition().getRow();

        List<Piece> jointPieces = new ArrayList<>(whiteTeam);
        jointPieces.addAll(blackTeam);

        while (position.getCol() != col && position.getRow() != row) {
            if (position.getCol() == super.getPosition().getCol()) {
                if (row < position.getRow()) {
                    row += 1;
                } else if (row > position.getRow()) {
                    row -= 1;
                }
            } else {
                if (col < position.getCol()) {
                    col += 1;
                } else if (col > position.getCol()) {
                    col -= 1;
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

        return true;
    }

    @Override
    public List<Position> getValidMoves(List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition) {
        throw new UnsupportedOperationException();
    }

    public TowerImage getPicture() {
        return picture;
    }

    public boolean asMoved() {
        return asMoved;
    }
}
