package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.PawnImage;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	
	private PawnImage picture;
	private boolean asMoved;
	
	
	public Pawn (Team team, Position position) {
		
		super(team, position);
	}
	
	
	public void initImage () {
		
		this.picture = new PawnImage(super.getCopy());
	}
	
	
	@Override
	public void move (int row, int col) {
		
		super.move(row, col);
		this.picture.updateImagePosition();
		this.asMoved = true;
	}
	
	
	@Override
	public boolean checkValidMove (Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
		
		if (!this.asMoved) {
			if (this.checkDoubleMove(position, whiteTeam, blackTeam)) {
				return true;
			}
		}
		
		if (super.getTeam() == Team.WHITE) {
			if (position.getRow() != super.getPosition().getRow() - 1) {
				return false;
			}
		} else {
			if (position.getRow() != super.getPosition().getRow() + 1) {
				return false;
			}
		}
		if (position.getCol() != super.getPosition().getCol() + 1 && position.getCol() != super.getPosition().getCol() - 1 && position.getCol() != super.getPosition().getCol()) {
			return false;
		}
		
		List<Piece> jointPieces = new ArrayList<>(whiteTeam);
		jointPieces.addAll(blackTeam);
		
		for (Piece piece : jointPieces) {
			if (piece.getPosition().equals(position)) {
				if (piece.getPosition().getCol() == super.getPosition().getCol()) {
					return false;
				} else if (piece.getPosition().getCol() == super.getPosition().getCol() + 1 || piece.getPosition().getCol() == super.getPosition().getCol() - 1) {
					return piece.getTeam() != super.getTeam();
				}
			}
		}
		return position.getCol() == super.getPosition().getCol();
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
		row = super.getPosition().getRow() + 2;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow() + 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		row = super.getPosition().getRow() + 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		row = super.getPosition().getRow() + 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow() - 2;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		
		col = super.getPosition().getCol();
		row = super.getPosition().getRow() - 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		row = super.getPosition().getRow() - 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		row = super.getPosition().getRow() - 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new Pawn(super.getTeam(), new Position(row, col)));
			
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
		
		return "Pawn" + super.getTeam() + getPosition().toString();
	}
	
	
	private boolean checkDoubleMove (Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
		
		if (super.getPosition().getCol() != position.getCol()) {
			return false;
		}
		if (super.getTeam() == Team.WHITE) {
			if (super.getPosition().getRow() - 2 != position.getRow()) {
				return false;
			}
		} else {
			if (super.getPosition().getRow() + 2 != position.getRow()) {
				return false;
			}
		}
		
		List<Piece> jointPieces = new ArrayList<>(whiteTeam);
		jointPieces.addAll(blackTeam);
		
		for (Piece piece : jointPieces) {
			if (piece.getPosition().equals(position)) {
				return false;
			} else if (super.getTeam() == Team.WHITE) {
				if (piece.getPosition().equals(new Position(position.getRow() + 1, position.getCol()))) {
					return false;
				}
			} else if (super.getTeam() == Team.BLACK) {
				if (piece.getPosition().equals(new Position(position.getRow() - 1, position.getCol()))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public PawnImage getPicture () {
		
		return picture;
	}
	
}
