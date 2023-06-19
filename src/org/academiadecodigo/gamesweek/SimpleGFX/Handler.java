package org.academiadecodigo.gamesweek.SimpleGFX;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


public class Handler implements MouseHandler {

    public Mouse mouse;

    public Handler(){
        mouse = new Mouse(this);
        mouseClicked(new MouseEvent(0,0));
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getY());
        System.out.println(mouseEvent.getX());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
