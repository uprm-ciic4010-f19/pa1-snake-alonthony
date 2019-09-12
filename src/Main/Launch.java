package Main;


/**
 * Created by AlexVR on 7/1/2018.
 */

public class Launch {

    public static void main(String[] args) {			   //(anthony) arregle la columna X y la fila Y
        GameSetUp game = new GameSetUp("Snake", 780, 780); // no existentes, los Valores originales
        game.start();									   // eran ("Snake", 800, 800)
    }
}
