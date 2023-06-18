import org.academiadecodigo.gamesweek.Pieces.PieceInitializer;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board.init();

//        Bishop bishopw = new Bishop(Team.WHITE, new Position(5, 1));
//        Bishop bishopb = new Bishop(Team.BLACK, new Position(7, 7));
//
//        Thread.sleep(500);
//
//        bishopb.getPosition().setNewPosition(2, 4);
//        bishopb.getPicture().updateImagePosition();
//
//        Thread.sleep(500);
//
//        bishopb.getPosition().setNewPosition(7, 7);
//        bishopb.getPicture().updateImagePosition();

        PieceInitializer.initWhitePieces();
        PieceInitializer.initBlackPieces();

        Game.test();
    }
}
