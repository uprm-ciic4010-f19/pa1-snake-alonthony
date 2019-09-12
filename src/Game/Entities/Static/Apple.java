package Game.Entities.Static;

import java.awt.Color;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {




	public int xCoord;
    public int yCoord;
    public int goodcounter=0;
    public Color color;
    public boolean good;
    
        public void tick() {
        	    goodcounter += 1;
             if(goodcounter >= 10) { // (Anthony) agregue variable para iterar la velocidad
                 goodcounter = 0;
                 this.good=false;
                 
        	}
           
        }
        
   
  

	//
    
	public boolean isGood(){
		return this.good;
    }
    
    
    
    public void setGood(boolean good) {
		this.good = good;
	}




	public Apple(Handler handler,int x, int y){
    	
        this.xCoord=x;
        this.yCoord=y;
    }
    

    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


	


	


}
