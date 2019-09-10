package Game.GameStates;

import java.awt.Graphics;

import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

public class GameOverState extends State {
	private int count = 0;
    private UIManager uiManager;

    //se crea la clase/state GameOver similar a la de Pause para cuando choque salga la imagen de game over
    //(Alondra)
    
    
    
    public GameOverState(Handler handler) {
    	
    	
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-64, handler.getHeight()/1-275, 128, 60, Images.butrestart, new ClickListlener() {
            @Override
            public void onClick() {     
            	handler.getMusicManager().playMusic("/music/restartSoundFX.wav"); //(Anthony) sonido en el boton "restart"
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().gameState);

            }
        }));
        


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


