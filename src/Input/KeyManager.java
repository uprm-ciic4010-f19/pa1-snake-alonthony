package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Handler;


/**
 * Created by AlexVR on 7/1/2018.
 */

public class KeyManager implements KeyListener {

	private boolean[] keys,justPressed,cantPress;
	public boolean up=false, down=false, left=false, right=false; 
	public boolean pbutt=false;
	public boolean w=false, a=false, s=false, d=false; // (anthony), teclas wasd para moverse
	public boolean arrowUp=false, arrowDown =false, arrowLeft=false, arrowRight=false;//
	
	public KeyManager(){

		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];

	}

	public void tick(){
		for(int i =0; i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i]=false;

			}else if(justPressed[i]){
				cantPress[i]=true;
				justPressed[i] =false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i]=true;
			}
		}

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        arrowUp = keys[KeyEvent.VK_UP];			//
		arrowDown = keys[KeyEvent.VK_DOWN];		//(anthony) variables
		arrowLeft = keys[KeyEvent.VK_LEFT];		//para direction keys
        arrowRight = keys[KeyEvent.VK_RIGHT];	//
		pbutt = keys[KeyEvent.VK_ESCAPE];			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

}
