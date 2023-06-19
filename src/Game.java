import org.academiadecodigo.gamesweek.Pieces.Piece;
import org.academiadecodigo.gamesweek.Pieces.PieceInitializer;
import org.academiadecodigo.gamesweek.Pieces.PieceTypes.Queen;
import org.academiadecodigo.gamesweek.Pieces.Position;
import org.academiadecodigo.gamesweek.Pieces.Team;
import org.academiadecodigo.gamesweek.SimpleGFX.Board;

import java.util.List;

public class Game {
    private static final List<Piece> whitePieces = PieceInitializer.initWhitePieces();
    private static final List<Piece> blackPieces = PieceInitializer.initBlackPieces();
    private static final Position whiteKingPosition = whitePieces.get(whitePieces.size() - 1).getPosition();
    private static final Team teamPlaying = Team.WHITE;
    private static final Position blackKingPosition = blackPieces.get(blackPieces.size() - 1).getPosition();
    private static Piece selectedPiece;
    
    public static void test () throws InterruptedException {
        whitePieces.add(new Queen(Team.WHITE, new Position(2, 7)));
        whitePieces.get(whitePieces.size() - 1).initImage();

//        Board.showValidMoves(whitePieces.get(whitePieces.size() - 1).getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition));
//
//        Thread.sleep(1000);
//
//        Board.hideValidMoves();
        
        whitePieces.get(whitePieces.size() - 1).move(5, 5);
        
        Board.showValidMoves(whitePieces.get(whitePieces.size() - 1).getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition), blackPieces);
    }
    
    public static void start () {
        Board.init();
        
        PieceInitializer.initImages(whitePieces, blackPieces);
    }
    
    public void selectPiece (Piece piece) {
        if (piece.getTeam() == teamPlaying) {
            selectedPiece = piece;
        }
    }
}
