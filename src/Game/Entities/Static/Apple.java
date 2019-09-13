package Game.Entities.Static;

import java.awt.Color;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {




	public int xCoord;
    public int yCoord;
    public int steps=0;
    
    
    
    
        
    
	public boolean isGood(){
		if (Game.Entities.Dynamic.Player.steps >= 80) {
			return false;
		} else {
			return true;
		}
    }
    
    
    
    


	public Apple(Handler handler,int x, int y){
    	
        this.xCoord=x;
        this.yCoord=y;
    }
    

  

	


}
