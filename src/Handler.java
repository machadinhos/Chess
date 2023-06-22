import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Pawn;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.List;


public class Handler implements MouseHandler {
	
	public Handler () {
		
		new Mouse(this);
		mouseClicked(new MouseEvent(0, 0));
	}
	
	
	@Override
	public void mouseClicked (MouseEvent mouseEvent) {
		
		if (Game.getGameState() == GameState.ENDED) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ignored) {
			}
			System.exit(0);
		} else if (Game.getGameState() == GameState.WAITINGTOCHANGEPAWNFORANOTHERDEADPIECE) {
			Position positionClicked = Board.pixelToPosition((int) mouseEvent.getX(), (int) mouseEvent.getY());
			
			List<Piece> team;
			
			if (Game.getTeamPlaying() == Team.WHITE) {
				team = Game.getBlackPiecesKilled();
			} else {
				team = Game.getWhitePiecesKilled();
			}
			
			for (Piece piece : Board.showSelectAPieceMenu(team)) {
				if (piece.getPosition().equals(positionClicked)) {
					Game.changePawnTo(piece);
					Game.setGameState(GameState.ONGOING);
					Board.hideSelectAPieceMenu();
					return;
				}
			}
			
			Board.showSelectAPieceMenu(team);
		} else if (Game.getGameState() == GameState.ONGOING) {
			if (Game.checkHasValidMoves()) {
				
				Position positionClicked = Board.pixelToPosition((int) mouseEvent.getX(), (int) mouseEvent.getY());
				
				if (Board.getValidMovesEllipse() == null || Board.getValidMovesEllipse().size() == 0) {
					Game.selectPiece(positionClicked);
				} else {
					boolean asMoved = false;
					for (Position position : Board.getValidMovesPositions()) {
						if (position.equals(positionClicked)) {
							Game.moveSelectedPiece(position);
							asMoved = true;
							
							if (Game.getSelectedPiece() instanceof Pawn) {
								if (positionClicked.getRow() == 0 || positionClicked.getRow() == 7) {
									Game.setGameState(GameState.WAITINGTOCHANGEPAWNFORANOTHERDEADPIECE);
									this.mouseClicked(mouseEvent);
								}
							}
							
							if (!Game.checkHasValidMoves()) {
								Game.setGameState(GameState.ENDED);
								
								String str;
								int growSize;
								
								if (Game.checkKingIsSafe()) {
									growSize = 110;
									str = "Tie...";
								} else {
									growSize = 75;
									if (Game.getTeamPlaying() == Team.WHITE) {
										str = "Black won!";
									} else {
										str = "White won!";
									}
								}
								
								Rectangle rectangle1 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
								Text text = new Text((double) Board.BOARDSIZE / 2 + 10, (double) Board.BOARDSIZE / 2 + 10, str);
								
								rectangle1.setColor(Color.WHITE);
								text.setColor(Color.BLACK);
								text.grow(200, growSize);
								
								Rectangle rectangle2 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
								
								rectangle2.setColor(Color.BLACK);
								rectangle2.draw();
								
								rectangle1.fill();
								text.draw();
							}
							break;
						}
					}
					
					if (Game.checkOnlyKingsAlive()) {
						Game.setGameState(GameState.ENDED);
						
						String str = "Tie...";
						
						Rectangle rectangle1 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
						Text text = new Text((double) Board.BOARDSIZE / 2 + 10, (double) Board.BOARDSIZE / 2 + 10, str);
						
						rectangle1.setColor(Color.WHITE);
						text.setColor(Color.BLACK);
						text.grow(200, 110);
						
						Rectangle rectangle2 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
						
						rectangle2.setColor(Color.BLACK);
						rectangle2.draw();
						
						rectangle1.fill();
						text.draw();
						
						this.mouseClicked(mouseEvent);
					}
					
					Board.hideValidMoves();
					
					if (!asMoved) {
						Game.selectPiece(positionClicked);
					}
				}
			} else {
				String str;
				int growSize;
				
				if (Game.checkKingIsSafe()) {
					growSize = 110;
					str = "Tie...";
				} else {
					growSize = 75;
					if (Game.getTeamPlaying() == Team.WHITE) {
						str = "Black won!";
					} else {
						str = "White won!";
					}
				}
				
				Rectangle rectangle1 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
				Text text = new Text((double) Board.BOARDSIZE / 2 + 10, (double) Board.BOARDSIZE / 2 + 10, str);
				
				rectangle1.setColor(Color.WHITE);
				text.setColor(Color.BLACK);
				text.grow(200, growSize);
				
				Rectangle rectangle2 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
				
				rectangle2.setColor(Color.BLACK);
				rectangle2.draw();
				
				rectangle1.fill();
				text.draw();
			}
		}
	}
	
	
	@Override
	public void mouseMoved (MouseEvent mouseEvent) {
	
	}
	
}
