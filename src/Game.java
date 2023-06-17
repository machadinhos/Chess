import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceInitializer;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

import java.util.List;

public class Game {
    private static final List<Piece> whitePieces = PieceInitializer.initWhitePieces();
    private static final List<Piece> blackPieces = PieceInitializer.initBlackPieces();
    private static Team teamPlaying = Team.WHITE;
    private static Piece selectedPiece;

    public void start () {
        throw new  UnsupportedOperationException();
    }

    public void selectPiece (Piece piece) {
        if (piece.getTeam() == teamPlaying) {
            selectedPiece = piece;
        }
    }
}
