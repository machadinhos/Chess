package org.academiadecodigo.gamesweek.Pieces;

/**
 * This enum represents the teams in chess.
 */
public enum Team {
	WHITE("White"), BLACK("Black");
	
	private final String team;
	
	
	Team (String team) {
		
		this.team = team;
	}
	
	
	/**
	 * Returns a String representation of th team.
	 *
	 * @return The String representation of the team.
	 */
	@Override
	public String toString () {
		
		return "Team{" + "team='" + team + '\'' + '}';
	}
}
