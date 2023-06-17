package org.academiadecodigo.gamesweek.Pieces;

import org.academiadecodigo.gamesweek.Position.Position;

public abstract class Piece {
    private Position position;

//    public Piece(Position position) {
//        this.position = position;
//    }

//    public abstract void move (Position newPosition);

    public void setNewPosition (int row, int col) {
        this.position.setNewPosition(row, col);
    }


}
