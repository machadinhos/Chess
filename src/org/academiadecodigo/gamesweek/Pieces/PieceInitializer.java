package org.academiadecodigo.gamesweek.Pieces;

import org.academiadecodigo.gamesweek.Pieces.PieceTypes.*;

import java.util.ArrayList;
import java.util.List;

public class PieceInitializer {
    public static List<Piece> initWhitePieces() {
        List<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(Team.WHITE, new Position(6, i)));
        }

        pieces.add(new Tower(Team.WHITE, new Position(7, 0)));
        pieces.add(new Tower(Team.WHITE, new Position(7, 7)));

        pieces.add(new Horse(Team.WHITE, new Position(7, 1)));
        pieces.add(new Horse(Team.WHITE, new Position(7, 6)));

        pieces.add(new Bishop(Team.WHITE, new Position(7, 2)));
        pieces.add(new Bishop(Team.WHITE, new Position(7, 5)));

        pieces.add(new Queen(Team.WHITE, new Position(7, 3)));
        pieces.add(new King(Team.WHITE, new Position(7, 4)));

        for (Piece piece : pieces) {
            piece.initImage();
        }

        return pieces;
    }

    public static List<Piece> initBlackPieces() {
        List<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(Team.BLACK, new Position(1, i)));
        }

        pieces.add(new Tower(Team.BLACK, new Position(0, 0)));
        pieces.add(new Tower(Team.BLACK, new Position(0, 7)));

        pieces.add(new Horse(Team.BLACK, new Position(0, 1)));
        pieces.add(new Horse(Team.BLACK, new Position(0, 6)));

        pieces.add(new Bishop(Team.BLACK, new Position(0, 2)));
        pieces.add(new Bishop(Team.BLACK, new Position(0, 5)));

        pieces.add(new Queen(Team.BLACK, new Position(0, 3)));
        pieces.add(new King(Team.BLACK, new Position(5, 3)));

        for (Piece piece : pieces) {
            piece.initImage();
        }

        return pieces;
    }
}
