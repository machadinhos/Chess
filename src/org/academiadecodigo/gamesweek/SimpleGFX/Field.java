package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
     private static final int SQUARESIZE = 70;
     private static final int PADDING = 10;
     private static final Rectangle[][] boardSquares = new Rectangle[8][8];

     public Field(){
          int xPosition = PADDING;
          int yPosition = PADDING;
          Color color = Color.WHITE;

          for (int row = 0; row < boardSquares.length; row++) {
               for (int square = 0; square < boardSquares[row].length; square++) {
                    boardSquares[row][square] = new Rectangle(xPosition, yPosition, SQUARESIZE, SQUARESIZE);
                    boardSquares[row][square].setColor(color);
                    boardSquares[row][square].fill();

                    if (color.equals(Color.WHITE)) {
                         color = Color.BLACK;
                    } else {
                         color = Color.WHITE;
                    }
                    xPosition += SQUARESIZE;
               }

               if (color.equals(Color.WHITE)) {
                    color = Color.BLACK;
               } else {
                    color = Color.WHITE;
               }

               xPosition = PADDING;
               yPosition += SQUARESIZE;
          }

     }

     public Rectangle createField() throws UnsupportedOperationException {
          throw new UnsupportedOperationException();
     }
}