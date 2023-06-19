import org.academiadecodigo.gamesweek.SimpleGFX.Board;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import javax.management.monitor.GaugeMonitor;


public class Handler implements MouseHandler {
    private Mouse mouse;

    public Handler(){
        mouse = new Mouse(this);
        mouseClicked(new MouseEvent(0,0));
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
//        System.out.println(Board.pixelToPosition( (int) mouseEvent.getX(), (int) mouseEvent.getY()));

        if (Board.getValidMoves() == null) {
            Game.selectPiece(Board.pixelToPosition((int) mouseEvent.getX(), (int) mouseEvent.getY()));
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
