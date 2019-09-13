package Game.Entities.Static;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

	public int xCoord;
    public int yCoord;
    public int steps=0;
    
	public boolean isGood(){
		if (Game.Entities.Dynamic.Player.steps >= 110) { //(anthony) modifique el timer porque le
			return false;								 // hice cambios a la velocidad de la serpiente
		} else {
			return true;
		}
    }
    
	public Apple(Handler handler,int x, int y){
    	
        this.xCoord=x;
        this.yCoord=y;
    }   
}
