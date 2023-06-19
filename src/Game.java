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
    private static Team teamPlaying = Team.WHITE;
    private static final Position blackKingPosition = blackPieces.get(blackPieces.size() - 1).getPosition();
    private static Piece selectedPiece;

    public static Piece getSelectedPiece() {
        return selectedPiece;
    }

    public static void test () throws InterruptedException {
        whitePieces.add(new Horse(Team.WHITE, new Position(5, 4)));
        whitePieces.get(whitePieces.size() - 1).initImage();

        Board.showValidMoves(whitePieces.get(whitePieces.size() - 1).getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition), blackPieces);
    }

    public static Team getTeamPlaying() {
        return teamPlaying;
    }

    public static void start () {
        Board.init();

        new Handler();

        PieceInitializer.initImages(whitePieces, blackPieces);
    }

    public static void moveSelectedPiece (Position position) {
        Board.hideValidMoves();

        selectedPiece.move(position.getRow(), position.getCol());

        List<Piece> enemyTeam;

        if (teamPlaying == Team.WHITE) {
            enemyTeam = blackPieces;
            teamPlaying = Team.BLACK;
        } else {
            enemyTeam = whitePieces;
            teamPlaying = Team.WHITE;
        }

        for (Piece piece : enemyTeam) {
            if (position.equals(piece.getPosition())) {
                enemyTeam.remove(piece);
                piece.die();
                break;
            }
        }
    }

    public static boolean checkHasValidMoves() {
        List<Piece> teaamPlayingPieces;

        if (teamPlaying == Team.WHITE) {
            teaamPlayingPieces = whitePieces;
        } else {
            teaamPlayingPieces = blackPieces;
        }

        for (Piece piece : teaamPlayingPieces) {
            if (piece.getValidMoves(whitePieces, blackPieces, whiteKingPosition, blackKingPosition).size() > 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void selectPiece (Position position) {
        if (Board.getValidMovesEllipse() != null) {
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
                Game.selectedPiece = piece;
            }
        }
    }
}
