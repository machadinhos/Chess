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
	
	
	public Tower (Team team, Position position) {
		
		super(team, position);
	}
	
	
	public void initImage () {
		
		this.picture = new TowerImage(super.getCopy());
	}
	
	
	@Override
	public void move (int row, int col) {
		
		super.move(row, col);
		this.picture.updateImagePosition();
		this.asMoved = true;
	}
	
	
	@Override
	public boolean checkValidMove (Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
		
		if (position.getCol() != super.getPosition().getCol() && position.getRow() != super.getPosition().getRow()) {
			return false;
		}
		
		int col = super.getPosition().getCol();
		int row = super.getPosition().getRow();
		
		List<Piece> jointPieces = new ArrayList<>(whiteTeam);
		jointPieces.addAll(blackTeam);
		
		while (position.getCol() != col || position.getRow() != row) {
			if (position.getCol() == super.getPosition().getCol()) {
				if (row < position.getRow()) {
					row++;
				} else if (row > position.getRow()) {
					row--;
				}
			} else {
				if (col < position.getCol()) {
					col++;
				} else if (col > position.getCol()) {
					col--;
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
	public List<Position> getValidMoves (List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition) {
		
		List<Position> validMoves = new ArrayList<>();
		
		List<Piece> enemyTeam;
		List<Piece> sameTeam;
		List<Piece> enemyTeamCopy;
		List<Piece> sameTeamCopy;
		Position teamKingPosition;
		
		if (super.getTeam() == Team.WHITE) {
			enemyTeam = blackTeam;
			sameTeam = whiteTeam;
			teamKingPosition = whiteKingPosition;
		} else {
			enemyTeam = whiteTeam;
			sameTeam = blackTeam;
			teamKingPosition = blackKingPosition;
		}
		
		int col;
		int row;
		boolean isKingSafe;
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow();
		
		while (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			isKingSafe = true;
			
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			row--;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Tower(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(teamKingPosition, sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(teamKingPosition, enemyTeamCopy, sameTeamCopy)) {
						isKingSafe = false;
						break;
					}
				}
			}
			
			if (isKingSafe) {
				if (row <= 7 && row >= 0) {
					if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
						validMoves.add(new Position(row, col));
					}
				}
			}
		}
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow();
		
		while (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			isKingSafe = true;
			
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			row++;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Tower(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(teamKingPosition, sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(teamKingPosition, enemyTeamCopy, sameTeamCopy)) {
						isKingSafe = false;
						break;
					}
				}
			}
			
			if (isKingSafe) {
				if (row <= 7 && row >= 0) {
					if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
						validMoves.add(new Position(row, col));
					}
				}
			}
		}
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow();
		
		while (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			isKingSafe = true;
			
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			col++;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Tower(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(teamKingPosition, sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(teamKingPosition, enemyTeamCopy, sameTeamCopy)) {
						isKingSafe = false;
						break;
					}
				}
			}
			
			if (isKingSafe) {
				if (col <= 7 && col >= 0) {
					if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
						validMoves.add(new Position(row, col));
					}
				}
			}
		}
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow();
		
		while (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			isKingSafe = true;
			
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			col--;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Tower(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(teamKingPosition, sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(teamKingPosition, enemyTeamCopy, sameTeamCopy)) {
						isKingSafe = false;
						break;
					}
				}
			}
			
			if (isKingSafe) {
				if (col <= 7 && col >= 0) {
					if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
						validMoves.add(new Position(row, col));
					}
				}
			}
		}
		
		return validMoves;
	}
	
	
	@Override
	public void die () {
		
		this.picture.delete();
	}
	
	
	@Override
	public String toString () {
		
		return "Tower" + super.getTeam() + getPosition().toString();
	}
	
	
	public TowerImage getPicture () {
		
		return picture;
	}
	
	
	public boolean asMoved () {
		
		return asMoved;
	}
	
}
