package Game.Entities.Static;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;

    public int xCoord;
    public int yCoord;
    public int goodcounter=0;
    public int goodSpeed = 0;
       // public void tick() {
        //	    goodcounter += 1;
          //   if(goodcounter >= goodSpeed) { // (Anthony) agregue variable para iterar la velocidad
    	   //  	checkCollisionAndMove():
            //     goodcounter = 0;  
              //   changeColor(Color.BLACK);
        	//}
           
       // }
        
   
   // private void changeColor(Color black) {
			// TODO Auto-generated method stub
			
	//	}


	//
    
	//public static void isGood(){
    	//if (equals(Color.WHITE)){
    		//true;
    		//System.out.println("Its good");
    		
		//}else {
			//false;
			//System.out.println("Ew");
			//}
    //}
    
    
    
    public Apple(Handler handler,int x, int y){
        this.handler=handler;
        this.xCoord=x;
        this.yCoord=y;
    }


}
