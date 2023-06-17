import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Bishop;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.Position.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.Field;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.BishopImage;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Field();

        Bishop bishopw = new Bishop(Team.WHITE, new Position(5, 1));
        Bishop bishopb = new Bishop(Team.BLACK, new Position(7, 7));

        BishopImage bw =  new BishopImage(bishopw);
        BishopImage bb = new BishopImage(bishopb);

        Thread.sleep(500);

        bishopb.getPosition().setNewPosition(2, 4);

        bw.updateImagePosition();
        bb.updateImagePosition();

        Thread.sleep(500);

        bishopb.getPosition().setNewPosition(7, 7);

        bw.updateImagePosition();
        bb.updateImagePosition();
    }
}
