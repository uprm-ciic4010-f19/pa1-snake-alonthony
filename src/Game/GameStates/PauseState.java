package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.ClickListlener; //(anthony)
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class PauseState extends State {

    private int count = 0;
    private UIManager uiManager;

    public PauseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-340, handler.getHeight()/2-180, 128, 64, Images.Resume, new ClickListlener()  {// (Anthony)
        	@Override																															   // modifique un poco el codigo
        	public void onClick() {																												   // para que los botones puedan		
            	handler.getMusicManager().playMusic("/music/resumeSoundFX.wav"); //(Anthony) sonido en el boton "Resume"						   // tener los sound effects  
        		handler.getMouseManager().setUimanager(null);																					    
        		State.setState(handler.getGame().gameState);																					    
        	}
        }));

        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-340, handler.getHeight()/2-100, 128, 64, Images.Options, new ClickListlener()  {// (Anthony)
        	@Override																															   // 
        	public void onClick() {																												   // 
            	handler.getMusicManager().playMusic("/music/configSFX.wav"); //(Anthony) sonido en el boton "Options"							   // 
        		handler.getMouseManager().setUimanager(null);																					   
                State.setState(handler.getGame().menuState);																					   
        	}
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-340, handler.getHeight()/2-20, 128, 64, Images.BTitle, new ClickListlener()  {// (Anthony)
        	@Override																															   // 
        	public void onClick() {																												   // 
            	handler.getMusicManager().playMusic("/music/TitleSFX.wav"); //(Anthony) sonido en el boton "BTitle"							   	   // 
        		handler.getMouseManager().setUimanager(null);																					   
                State.setState(handler.getGame().menuState);																					   
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
        g.drawImage(Images.Pause,0,0,handler.getWidth(),handler.getHeight(),null);//cambiar el size del display
        																	 //para que asi cubra el "window" (alondra)
        uiManager.Render(g);

    }
}
