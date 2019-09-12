package Main;


/**
 * Created by AlexVR on 7/1/2018.
 */

public class Launch {

    public static void main(String[] args) {
        GameSetUp game = new GameSetUp("Snake", 780, 780); // Valores originales
        game.start();									   // ("Snake", 800, 800)
    }
}
