package org.academiadecodigo.gamesweek.Pieces.PieceTypes;

import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.KingImage;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	
	private KingImage picture;
	private boolean asMoved;
	
	
	public King (Team team, Position position) {
		
		super(team, position);
	}
	
	
	public void initImage () {
		
		this.picture = new KingImage(super.getCopy());
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
			if (this.checkRook(position, whiteTeam, blackTeam)) {
				return true;
			}
		}
		
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
		
		return (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() == position.getRow()) || (super.getPosition().getCol() == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) || (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() == position.getRow()) || (super.getPosition().getCol() == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) || (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow()) || (super.getPosition().getCol() - 1 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) || (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() - 1 == position.getRow()) || (super.getPosition().getCol() + 1 == position.getCol() && super.getPosition().getRow() + 1 == position.getRow());
	}
	
	
	@Override
	public List<Position> getValidMoves (List<Piece> whiteTeam, List<Piece> blackTeam, Position whiteKingPosition, Position blackKingPosition) {
		
		List<Position> validMoves = new ArrayList<>();
		
		List<Piece> enemyTeam;
		List<Piece> sameTeam;
		List<Piece> enemyTeamCopy;
		List<Piece> sameTeamCopy;
		
		if (super.getTeam() == Team.WHITE) {
			enemyTeam = blackTeam;
			sameTeam = whiteTeam;
		} else {
			enemyTeam = whiteTeam;
			sameTeam = blackTeam;
		}
		
		int col;
		int row;
		boolean isKingSafe;
		
		col = super.getPosition().getCol() + 1;
		row = super.getPosition().getRow() + 1;
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
		row = super.getPosition().getRow();
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
		row = super.getPosition().getRow();
		isKingSafe = true;
		
		if (col <= 7 && row <= 7 && col >= 0 && row >= 0) {
			enemyTeamCopy = new ArrayList<>(enemyTeam);
			sameTeamCopy = new ArrayList<>(sameTeam);
			
			sameTeamCopy.remove(super.getCopy());
			sameTeamCopy.add(new King(super.getTeam(), new Position(row, col)));
			
			for (Piece enemy : enemyTeam) {
				if (enemy.getPosition().equals(new Position(row, col))) {
					enemyTeamCopy.remove(enemy);
					break;
				}
			}
			
			for (Piece enemy : enemyTeamCopy) {
				if (super.getTeam() == Team.WHITE) {
					if (enemy.checkValidMove(new Position(row, col), sameTeamCopy, enemyTeamCopy)) {
						isKingSafe = false;
						break;
					}
				} else {
					if (enemy.checkValidMove(new Position(row, col), enemyTeamCopy, sameTeamCopy)) {
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
		
		Position rockPosition1 = new Position(this.getPosition().getRow(), this.getPosition().getCol() + 2);
		Position rockPosition2 = new Position(this.getPosition().getRow(), this.getPosition().getCol() - 2);
		
		if (this.checkValidMove(rockPosition1, whiteTeam, blackTeam)) {
			
			validMoves.add(rockPosition1);
		}
		if (this.checkValidMove(rockPosition2, whiteTeam, blackTeam)) {
			validMoves.add(rockPosition2);
		}
		
		return validMoves;
	}
	
	
	@Override
	public void die () {
		
		this.picture.delete();
	}
	
	
	@Override
	public String toString () {
		
		return "King" + super.getTeam() + getPosition().toString();
	}
	
	
	private boolean checkRook (Position position, List<Piece> whiteTeam, List<Piece> blackTeam) {
		
		if (super.getPosition().getRow() == position.getRow()) {
			if (position.getCol() == super.getPosition().getCol() - 2 || position.getCol() == super.getPosition().getCol() + 2) {
				int towerCol;
				if (position.getCol() == super.getPosition().getCol() - 2) {
					towerCol = 0;
				} else {
					towerCol = 7;
				}
				
				List<Piece> sameTeam;
				
				if (super.getTeam() == Team.WHITE) {
					sameTeam = whiteTeam;
				} else {
					sameTeam = blackTeam;
				}
				
				boolean hasValidTower = false;
				
				for (Piece piece : sameTeam) {
					if (piece instanceof Tower tower) {
						if (tower.asMoved()) {
							continue;
						}
						if (piece.getPosition().getCol() != towerCol) {
							continue;
						}
						hasValidTower = true;
						break;
					}
				}
				
				if (!hasValidTower) {
					return false;
				}
				
				List<Piece> jointPieces = new ArrayList<>(whiteTeam);
				jointPieces.addAll(blackTeam);
				
				for (Piece piece : jointPieces) {
					if (piece.getPosition().getRow() == super.getPosition().getRow()) {
						if (super.getPosition().getCol() < position.getCol()) {
							if (piece.getPosition().getCol() == 6 || piece.getPosition().getCol() == 5) {
								return false;
							}
						} else {
							if (piece.getPosition().getCol() == 1 || piece.getPosition().getCol() == 2 || piece.getPosition().getCol() == 3) {
								return false;
							}
						}
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	public KingImage getPicture () {
		
		return picture;
	}
	
}
