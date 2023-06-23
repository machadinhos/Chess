import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceInitializer;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.King;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Tower;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private static final List<Piece> whitePieces = PieceInitializer.initWhitePieces();
	private static final List<Piece> blackPieces = PieceInitializer.initBlackPieces();
	private static final Position whiteKingPosition = whitePieces.get(whitePieces.size() - 1).getPosition();
	private static final Position blackKingPosition = blackPieces.get(blackPieces.size() - 1).getPosition();
	private static final List<Piece> whitePiecesKilled = new ArrayList<>();
	private static final List<Piece> blackPiecesKilled = new ArrayList<>();
	private static Team teamPlaying = Team.WHITE;
	private static Piece selectedPiece;
	private static GameState gameState = GameState.ONGOING;
	
	
	public static GameState getGameState () {
		
		return gameState;
	}
	
	
	public static void setGameState (GameState gameState) {
		
		Game.gameState = gameState;
	}
	
	
	public static Piece getSelectedPiece () {
		
		return selectedPiece;
	}
	
	
	public static Team getTeamPlaying () {
		
		return teamPlaying;
	}
	
	
	public static void start () {
		
		Board.init();
		
		new Handler();
		
		PieceInitializer.initImages(whitePieces, blackPieces);
	}
	
	
	public static List<Piece> getWhitePiecesKilled () {
		
		return whitePiecesKilled;
	}
	
	
	public static List<Piece> getBlackPiecesKilled () {
		
		return blackPiecesKilled;
	}
	
	
	public static void moveSelectedPiece (Position position) {
		
		System.out.println("White pieces alive -> " + whitePieces.size());
		System.out.println("Black pieces alive -> " + blackPieces.size());
		
		if (selectedPiece instanceof King) {
			if (selectedPiece.getPosition().getCol() - 2 == position.getCol() || selectedPiece.getPosition().getCol() + 2 == position.getCol()) {
				int colTower;
				if (selectedPiece.getPosition().getCol() - 2 == position.getCol()) {
					colTower = 0;
				} else {
					colTower = 7;
				}
				
				selectedPiece.move(position.getRow(), position.getCol());
				
				List<Piece> sameTeam;
				
				if (teamPlaying == Team.WHITE) {
					sameTeam = whitePieces;
				} else {
					sameTeam = blackPieces;
				}
				
				for (Piece piece : sameTeam) {
					if (piece instanceof Tower tower) {
						if (tower.getPosition().getCol() == colTower && !tower.asMoved()) {
							if (colTower == 0) {
								tower.move(position.getRow(), 3);
							} else {
								tower.move(position.getRow(), 5);
							}
							
							if (teamPlaying == Team.WHITE) {
								teamPlaying = Team.BLACK;
							} else {
								teamPlaying = Team.WHITE;
							}
							
							return;
						}
					}
				}
			}
		}
		
		Board.hideValidMoves();
		
		selectedPiece.move(position.getRow(), position.getCol());
		
		List<Piece> enemyTeam;
		
		if (teamPlaying == Team.WHITE) {
			enemyTeam = blackPieces;
			teamPlaying = Team.BLACK;
		} else {
			enemyTeam = whitePieces;
			teamPlaying = Team.WHITE;
		}
		
		for (Piece piece : enemyTeam) {
			if (position.equals(piece.getPosition())) {
				enemyTeam.remove(piece);
				piece.die();
				if (teamPlaying == Team.WHITE) {
					whitePiecesKilled.add(piece);
				} else {
					blackPiecesKilled.add(piece);
				}
				break;
			}
		}
	}
	
	
	public static boolean checkHasValidMoves () {
		
		List<Piece> teaamPlayingPieces;
		
		if (teamPlaying == Team.WHITE) {
			teaamPlayingPieces = whitePieces;
		} else {
			teaamPlayingPieces = blackPieces;
		}
		
		for (Piece piece : teaamPlayingPieces) {
			if (piece.getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition).size() > 0) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void selectPiece (Position position) {
		
		if (Board.getValidMovesEllipse() != null) {
			Board.hideValidMoves();
		}
		
		List<Piece> sameTeam;
		List<Piece> enemyTeam;
		
		if (Game.teamPlaying == Team.WHITE) {
			sameTeam = whitePieces;
			enemyTeam = blackPieces;
		} else {
			sameTeam = blackPieces;
			enemyTeam = whitePieces;
		}
		
		for (Piece piece : sameTeam) {
			if (piece.getPosition().equals(position)) {
				Board.showValidMoves(piece.getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition), enemyTeam);
				Game.selectedPiece = piece;
			}
		}
	}
	
	
	public static boolean checkKingIsSafe () {
		
		Position kingPlayingPosition;
		List<Piece> enemyTeam;
		
		if (teamPlaying == Team.WHITE) {
			kingPlayingPosition = whiteKingPosition;
			enemyTeam = blackPieces;
		} else {
			kingPlayingPosition = blackKingPosition;
			enemyTeam = whitePieces;
		}
		
		for (Piece enemy : enemyTeam) {
			if (enemy.checkValidMove(kingPlayingPosition, whitePieces, blackPieces)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static boolean checkOnlyKingsAlive () {
		
		return blackPieces.size() == 1 && whitePieces.size() == 1;
	}
	
	
	public static void changePawnTo (Piece piece) {
		
		Game.selectedPiece.die();
		
		Game.whitePieces.remove(Game.selectedPiece);
		Game.blackPieces.remove(Game.selectedPiece);
		
		piece.move(selectedPiece.getPosition().getRow(), selectedPiece.getPosition().getCol());
		
		piece.initImage();
		
		Board.hideSelectAPieceMenu();
		
		Game.blackPiecesKilled.remove(piece);
		Game.whitePiecesKilled.remove(piece);
		
		if (piece.getTeam() == Team.WHITE) {
			Game.whitePieces.add(piece);
		} else {
			Game.blackPieces.add(piece);
		}
	}
	
}
