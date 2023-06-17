package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Position.Position;

public class Bishop extends Piece {
    public Bishop(Position position) {
        super(position);
    }

    @Override
    public void move(Position newPosition) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean checkValidMove() {
        throw new UnsupportedOperationException();
    }
}
