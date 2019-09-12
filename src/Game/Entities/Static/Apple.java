package Game.Entities.Static;

import java.awt.Color;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

<<<<<<< HEAD



	public int xCoord;
=======
    private Handler handler;

    public int xCoord;
>>>>>>> branch 'master' of https://github.com/uprm-ciic4010-f19/pa1-snake-alonthony.git
    public int yCoord;
    public int goodcounter=0;
<<<<<<< HEAD
    public Color color;
    public boolean good;
=======
    public int goodSpeed = 0;
>>>>>>> branch 'master' of https://github.com/uprm-ciic4010-f19/pa1-snake-alonthony.git
    
<<<<<<< HEAD
        public void tick() {
        	    goodcounter += 1;
             if(goodcounter >= 10) { // (Anthony) agregue variable para iterar la velocidad
                 goodcounter = 0;
                 this.good=false;
                 color = Color.BLACK;
        	}
=======
       // public void tick() {
        //	    goodcounter += 1;
          //   if(goodcounter >= goodSpeed) { // (Anthony) agregue variable para iterar la velocidad
    	   //  	checkCollisionAndMove():
            //     goodcounter = 0;  
              //   changeColor(Color.BLACK);
        	//}
>>>>>>> branch 'master' of https://github.com/uprm-ciic4010-f19/pa1-snake-alonthony.git
           
        }
        
   
  

	//
    
	public boolean isGood(){
		return this.good;
    }
    
    
    
<<<<<<< HEAD
    public void setGood(boolean good) {
		this.good = good;
	}




	public Apple(Handler handler,int x, int y){
    	
=======
    public Apple(Handler handler,int x, int y){
        this.handler=handler;
>>>>>>> branch 'master' of https://github.com/uprm-ciic4010-f19/pa1-snake-alonthony.git
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
