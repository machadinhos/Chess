import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


public class Handler implements MouseHandler {
    private final Mouse mouse;
    
    public Handler () {
        mouse = new Mouse(this);
        mouseClicked(new MouseEvent(0, 0));
    }
    
    @Override
    public void mouseClicked (MouseEvent mouseEvent) {
//        System.out.println(Board.pixelToPosition((int) mouseEvent.getX(), (int) mouseEvent.getY()));
//        System.out.println(mouseEvent.getX());
//        System.out.println(mouseEvent.getY());
        
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
                        
                        if (!Game.checkHasValidMoves()) {
                            String str;
                            if (Game.getTeamPlaying() == Team.WHITE) {
                                str = "Black won!";
                            } else {
                                str = "White won!";
                            }
                            
                            Rectangle rectangle1 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
                            Text text = new Text((double) Board.BOARDSIZE / 2 + 10, (double) Board.BOARDSIZE / 2 + 10, str);
                            
                            rectangle1.setColor(Color.WHITE);
                            text.setColor(Color.BLACK);
                            text.grow(200, 75);
                            
                            Rectangle rectangle2 = new Rectangle((double) Board.BOARDSIZE / 2 - 315, (double) Board.BOARDSIZE / 2 - 90, 650, 200);
                            
                            rectangle2.setColor(Color.BLACK);
                            rectangle2.draw();
                            
                            rectangle1.fill();
                            text.draw();
                        }
                        break;
                    }
                }
                
                Board.hideValidMoves();
                
                if (!asMoved) {
                    Game.selectPiece(positionClicked);
                }
            }
        }
    }
    
    @Override
    public void mouseMoved (MouseEvent mouseEvent) {
    
    }
}
