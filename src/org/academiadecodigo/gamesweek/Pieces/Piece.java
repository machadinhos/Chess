package org.academiadecodigo.gamesweek.Pieces;

import java.util.List;

public abstract class Piece {
    private final Team team;
    private final Position position;

    public Piece(Team team, Position position) {
        this.team = team;
        this.position = position;
    }

    public abstract void initImage();

    public Piece getCopy() {
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public void move(int row, int col) {
        this.position.setNewPosition(row, col);
    }

    public abstract boolean checkValidMove(Position position, List<Piece> whiteTeam, List<Piece> blackTeam);

    public abstract List<Position> getValidMoves(List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition);

    @Override
    public String toString() {
        return "Piece " + this.team.toString() + getPosition().toString();
    }
}
