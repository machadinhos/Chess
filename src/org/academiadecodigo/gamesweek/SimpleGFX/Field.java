package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
     public static final int SQUARESIZE = 90;
     public static final int PADDING = 10;
     private static final Rectangle[][] boardSquares = new Rectangle[8][8];

     public Field(){
          int xPosition = PADDING + 1;
          int yPosition = PADDING + 1;
          Color color = Color.WHITE;

          Rectangle border = new Rectangle(PADDING, PADDING, SQUARESIZE * 8 + 1, SQUARESIZE * 8 + 1);
          border.draw();

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

               xPosition = PADDING + 1;
               yPosition += SQUARESIZE;
          }

     }

     public Rectangle createField() throws UnsupportedOperationException {
          throw new UnsupportedOperationException();
     }
}
