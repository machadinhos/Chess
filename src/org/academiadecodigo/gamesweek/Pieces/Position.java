package org.academiadecodigo.gamesweek.Pieces;

public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setNewPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Position position) {
        return this.row == position.getRow() && this.col == position.getCol();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
