import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Bishop;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.King;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.Position.Position;
import org.academiadecodigo.gamesweek.SimpleGFX.Field;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.BishopImage;
import org.academiadecodigo.gamesweek.SimpleGFX.PiecesImages.KingImage;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Field();

        BishopImage bw =  new BishopImage(new Bishop(Team.BLACK, new Position(1, 1)));
        BishopImage bb = new BishopImage(new Bishop(Team.WHITE, new Position(5, 1)));
        KingImage bK = new KingImage(new King(Team.WHITE, new Position(4, 1)));

        Thread.sleep(500);

        bw.updateImagePosition();

        Thread.sleep(500);

        bw.updateImagePosition();
    }
}
