package Game.GameStates;

import java.awt.Graphics;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

public class GameOverState extends State {
	private int count = 0;
    private UIManager uiManager;

    //se crea la clase/state GameOver similar a la de Pause para cuando choque salga la imagen de game over
    //la unica diferencia es que el game over no va a tener botones (Alondra)
    
    public GameOverState(Handler handler) {
    	
    	
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


        


    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;

            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.GameOver,0,0,handler.getWidth(),handler.getHeight(),null); //para llamar a la imagen
        uiManager.Render(g);                     									//(Alondra)

    }
}


