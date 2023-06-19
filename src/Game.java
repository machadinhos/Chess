import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceInitializer;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Horse;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final List<Piece> whitePieces = PieceInitializer.initWhitePieces();
    private static final List<Piece> blackPieces = PieceInitializer.initBlackPieces();
    private static final Position whiteKingPosition = whitePieces.get(whitePieces.size() - 1).getPosition();
    private static final Team teamPlaying = Team.WHITE;
    private static final Position blackKingPosition = blackPieces.get(blackPieces.size() - 1).getPosition();
    private static Piece selectedPiece;
    
    public static void test () throws InterruptedException {
        whitePieces.add(new Horse(Team.WHITE, new Position(5, 4)));
        whitePieces.get(whitePieces.size() - 1).initImage();

        Board.showValidMoves(whitePieces.get(whitePieces.size() - 1).getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition), blackPieces);
    }
    
    public static void start () {
        Board.init();

        new Handler();

        PieceInitializer.initImages(whitePieces, blackPieces);
    }
    
    public static void selectPiece (Position position) {
        if (Board.getValidMoves() != null) {
            Board.hideValidMoves();
        }

        List<Piece> sameTeam = new ArrayList<>();
        List<Piece> enemyTeam = new ArrayList<>();

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
            }
        }
    }
}
