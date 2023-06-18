package org.academiadecodigo.gamesweek.Pieces;

public enum Team {
    WHITE("White"),
    BLACK("Black");

    private final String team;

    Team(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team='" + team + '\'' +
                '}';
    }
}
