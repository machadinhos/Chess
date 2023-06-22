package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.BishopImage;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
	
	private BishopImage picture;
	
	
	public Bishop (Team team, Position position) {
		
		super(team, position);
	}
	
	
	public void initImage () {
		
		this.picture = new BishopImage(super.getCopy());
	}
	
	
	@Override
	public void move (int row, int col) {
		
		super.move(row, col);
		this.picture.updateImagePosition();
	}
	
	
	@Override
	public boolean checkValidMove (Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
		
		if (Math.abs(super.getPosition().getCol() - position.getCol()) == Math.abs(super.getPosition().getRow() - position.getRow())) {
			int col = super.getPosition().getCol();
			int row = super.getPosition().getRow();
			
			List<Piece> jointPieces = new ArrayList<>(whiteTeam);
			jointPieces.addAll(blackTeam);
			
			while (position.getCol() != col && position.getRow() != row) {
				if (col < position.getCol()) {
					col++;
				} else if (col > position.getCol()) {
					col--;
				}
				if (row < position.getRow()) {
					row++;
				} else if (row > position.getRow()) {
					row--;
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
		return false;
	}
	
	
	@Override
	public List<Position> getValidMoves (List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition) {
		
		List<Position> validMoves = new ArrayList<>();
		
		List<Piece> enemyTeam;
		List<Piece> sameTeam;
		List<Piece> sameTeamCopy;
		List<Piece> enemyTeamCopy;
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
			
			col++;
			row++;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Bishop(super.getTeam(), new Position(row, col)));
			
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
				if (row <= 7 && col <= 7 && row >= 0 && col >= 0) {
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
			row--;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Bishop(super.getTeam(), new Position(row, col)));
			
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
				if (row <= 7 && col <= 7 && row >= 0 && col >= 0) {
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
			row++;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Bishop(super.getTeam(), new Position(row, col)));
			
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
				if (row <= 7 && col <= 7 && row >= 0 && col >= 0) {
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
			row--;
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Bishop(super.getTeam(), new Position(row, col)));
			
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
				if (row <= 7 && col <= 7 && row >= 0 && col >= 0) {
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
		
		return "Bishop" + super.getTeam() + getPosition().toString();
	}
	
	
	public BishopImage getPicture () {
		
		return picture;
	}
	
}
