package org.academiadecodigo.gamesweek.Pieces;

import org.academiadecodigo.gamesweek.Position.Position;

public abstract class Piece {
    private final Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setNewPosition (int row, int col) {
        this.position.setNewPosition(row, col);
    }

    public abstract void move (Position newPosition);

    public abstract boolean checkValidMove ();
}
