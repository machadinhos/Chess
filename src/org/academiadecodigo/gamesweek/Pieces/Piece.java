package org.academiadecodigo.gamesweek.Pieces;

import org.academiadecodigo.gamesweek.Position.Position;

public abstract class Piece {
    private final Team team;
    private final Position position;

    public Piece(Team team, Position position) {
        this.team = team;
        this.position = position;
    }

    public Piece getCopy() {
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public void setNewPosition(int row, int col) {
        this.position.setNewPosition(row, col);
    }

    public abstract void move(Position newPosition);

    public abstract boolean checkValidMove();
}
