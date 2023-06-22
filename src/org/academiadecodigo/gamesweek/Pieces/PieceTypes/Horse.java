package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.HorseImage;

import java.util.ArrayList;
import java.util.List;

public class Horse extends Piece {
	
	private HorseImage picture;
	
	
	public Horse (Team team, Position position) {
		
		super(team, position);
	}
	
	
	public void initImage () {
		
		this.picture = new HorseImage(super.getCopy());
	}
	
	
	@Override
	public void move (int row, int col) {
		
		super.move(row, col);
		this.picture.updateImagePosition();
	}
	
	
	@Override
	public boolean checkValidMove (Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
		
		List<Piece> piecesSameTeam;
		if (super.getTeam() == Team.WHITE) {
			piecesSameTeam = whiteTeam;
		} else {
			piecesSameTeam = blackTeam;
		}
		
		for (Piece piece : piecesSameTeam) {
			if (piece.getPosition().equals(position)) {
				return false;
			}
		}
		
		return (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() + 2 == position.getRow()) || (super.getPosition().getCol() + 2 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) || (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() + 2 == position.getRow()) || (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() - 2 == position.getRow()) || (super.getPosition().getCol() - 2 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) || (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() - 2 == position.getRow()) || (super.getPosition().getCol() + 2 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) || (super.getPosition().getCol() - 2 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow());
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
		
		col = super.getPosition().getCol() + 1;
		row = super.getPosition().getRow() + 2;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() - 1;
		row = super.getPosition().getRow() + 2;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() + 1;
		row = super.getPosition().getRow() - 2;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() - 1;
		row = super.getPosition().getRow() - 2;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() + 2;
		row = super.getPosition().getRow() + 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() - 2;
		row = super.getPosition().getRow() + 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() + 2;
		row = super.getPosition().getRow() - 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
				}
			}
		}
		
		col = super.getPosition().getCol() - 2;
		row = super.getPosition().getRow() - 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Horse(super.getTeam(), new Position(row, col)));
			
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
				if (this.checkValidMove(new Position(row, col), whiteTeam, blackTeam)) {
					validMoves.add(new Position(row, col));
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
		
		return "Horse" + super.getTeam() + getPosition().toString();
	}
	
	
	public HorseImage getPicture () {
		
		return picture;
	}
	
}
