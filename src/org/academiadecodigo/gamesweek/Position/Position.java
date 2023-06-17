package org.academiadecodigo.gamesweek.Position;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setNewPosition (int row, int col) {
        this.row = row;
        this.col = col;
    }
}
