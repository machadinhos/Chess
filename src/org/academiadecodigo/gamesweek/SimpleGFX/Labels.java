package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Labels {

    public static void init() {
        Text letterA = new Text(Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "a");
        letterA.setColor(Color.WHITE);
        letterA.grow(4, 8);
        letterA.draw();

        Text letterB = new Text(2 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "b");
        letterB.setColor(Color.BLACK);
        letterB.grow(4, 8);
        letterB.draw();


        Text letterC = new Text(3 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "c");
        letterC.setColor(Color.WHITE);
        letterC.grow(4, 8);
        letterC.draw();


        Text letterD = new Text(4 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "d");
        letterD.setColor(Color.BLACK);
        letterD.grow(4, 8);
        letterD.draw();


        Text letterE = new Text(5 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "e");
        letterE.setColor(Color.WHITE);
        letterE.grow(4, 8);
        letterE.draw();


        Text letterF = new Text(6 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "f");
        letterF.setColor(Color.BLACK);
        letterF.grow(4, 8);
        letterF.draw();


        Text letterG = new Text(7 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - 14, "g");
        letterG.setColor(Color.WHITE);
        letterG.grow(4, 8);
        letterG.draw();


        Text letterH = new Text(8 * Field.SQUARESIZE - 2, 8 * Field.SQUARESIZE - Field.PADDING, "h");
        letterH.setColor(Color.BLACK);
        letterH.grow(4, 8);
        letterH.draw();


        Text letter1 = new Text(Field.PADDING + 5, 7 * Field.SQUARESIZE + Field.PADDING + 4, "1");
        letter1.setColor(Color.WHITE);
        letter1.grow(4, 8);
        letter1.draw();


        Text letter2 = new Text(Field.PADDING + 5, 6 * Field.SQUARESIZE + Field.PADDING + 4, "2");
        letter2.setColor(Color.BLACK);
        letter2.grow(4, 8);
        letter2.draw();


        Text letter3 = new Text(Field.PADDING + 5, 5 * Field.SQUARESIZE + Field.PADDING + 4, "3");
        letter3.setColor(Color.WHITE);
        letter3.grow(4, 8);
        letter3.draw();


        Text letter4 = new Text(Field.PADDING + 5, 4 * Field.SQUARESIZE + Field.PADDING + 4, "4");
        letter4.setColor(Color.BLACK);
        letter4.grow(4, 8);
        letter4.draw();


        Text letter5 = new Text(Field.PADDING + 5, 3 * Field.SQUARESIZE + Field.PADDING + 4, "5");
        letter5.setColor(Color.WHITE);
        letter5.grow(4, 8);
        letter5.draw();


        Text letter6 = new Text(Field.PADDING + 5, 2 * Field.SQUARESIZE + Field.PADDING + 4, "6");
        letter6.setColor(Color.BLACK);
        letter6.grow(4, 8);
        letter6.draw();


        Text letter7 = new Text(Field.PADDING + 5, Field.SQUARESIZE + Field.PADDING + 4, "7");
        letter7.setColor(Color.WHITE);
        letter7.grow(4, 8);
        letter7.draw();


        Text letter8 = new Text(Field.PADDING + 5, Field.PADDING + 4, "8");
        letter8.setColor(Color.BLACK);
        letter8.grow(4, 8);
        letter8.draw();
    }
}
