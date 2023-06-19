import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


public class Handler implements MouseHandler {
    private final Mouse mouse;

    public Handler(){
        mouse = new Mouse(this);
        mouseClicked(new MouseEvent(0,0));
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
//        System.out.println(Board.pixelToPosition( (int) mouseEvent.getX(), (int) mouseEvent.getY()));
        Position positionClicked = Board.pixelToPosition((int) mouseEvent.getX(), (int) mouseEvent.getY());

        if (Board.getValidMovesEllipse() == null) {
            Game.selectPiece(positionClicked);
        } else {
            for (Position position : Board.getValidMovesPositions()) {
                if (position.equals(positionClicked)) {
                    Board.hideValidMoves();
                    Game.getSelectedPiece().move(position.getRow(), position.getCol());
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
