import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Picture picture = new Picture(10, 10, "resources/ChessPieces/bB.png");

        picture.draw();
    }
}