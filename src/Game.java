import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceInitializer;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.*;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;

import java.util.List;
import java.util.function.BiPredicate;

public class Game {
    private static final List<Piece> whitePieces = PieceInitializer.initWhitePieces();
    private static final List<Piece> blackPieces = PieceInitializer.initBlackPieces();
    private static final Position whiteKingPosition = whitePieces.get(whitePieces.size() - 1).getPosition();
    private static Position blackKingPosition = blackPieces.get(blackPieces.size() - 1).getPosition();
    private static final Team teamPlaying = Team.WHITE;
    private static Piece selectedPiece;

    public static void test() throws InterruptedException {
        whitePieces.add(new Pawn(Team.WHITE, new Position(2, 7)));
        whitePieces.get(whitePieces.size() - 1).initImage();

        Board.showValidMoves(whitePieces.get(whitePieces.size() - 1).getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition));

        Thread.sleep(1000);

        Board.hideValidMoves();

        whitePieces.get(whitePieces.size() - 1).move(4, 7);

        Board.showValidMoves(whitePieces.get(whitePieces.size() - 1).getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition));
    }

    public void start() {
        throw new UnsupportedOperationException();
    }

    public void selectPiece(Piece piece) {
        if (piece.getTeam() == teamPlaying) {
            selectedPiece = piece;
        }
    }
}
