package Game.Entities.Dynamic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import Main.Handler;


/**
 * Created by AlexVR on 7/2/2018.
 */
public class Player {

    
	public int length;
    public boolean justAte;
    private Handler handler;

    public int xCoord;
    public int yCoord;

    public int moveCounter; 
    public int speedManager; //(anthony) variable
    
    public String direction;//is your first name one?
	private double currScore; 
	public Graphics g;
	
	
	public Player(Handler handler){
        this.handler = handler;
        xCoord = 30; // og - 0
        yCoord = 30; // og - 0
        moveCounter = 1; // og -0
        speedManager = 4; // (anthony) variable nueva
        direction= "Down"; // og - "Right"
        justAte = false;
        length= 1;
        currScore = 0;
        
    }

	public void tick(){
        moveCounter += 1;
        if(moveCounter >= speedManager) { // (Anthony) agregue variable para iterar la velocidad
            checkCollisionAndMove();
            moveCounter += 2; 
            speedManager -= 1;
        	
      //  }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)){
      //     direction="Up";
      //  }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)){
      //      direction="Down";
      //  }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
      //      direction="Left";
      //  }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
      //      direction="Right";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)){
        	direction="Up";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)){
        	direction="Down";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)){
        	direction="Left";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)){
        	direction="Right";    
            
            
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)){
            direction="Up";
            
            
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)){
            direction="Down";
            
            
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
            direction="Left";
            
            
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
            direction="Right";
            
            
            
            
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)) { //cuando presiones N te agrega un segmento de la cola (Alondra)
        	handler.getWorld().body.addFirst(new Tail(xCoord, yCoord, handler));
        	
        }if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) { //cuando presione ESC se pausa el juego (Alondra)
        	Game.GameStates.State.setState(handler.getGame().pauseState);
        }
        	
	   /**
		* (Anthony) - En el siguiente codigo implemento los comandos de "+" y "-" para
		* aumentar o disminuir la velocidad de la serpiente
		*/
     
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_EQUALS)) {
        	checkCollisionAndMove();
        	speedManager -= 15;
        	moveCounter += 10;
        }if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_MINUS)) {
        	checkCollisionAndMove();
        	speedManager += 15;
        	moveCounter -= 10;
        }
	}        	
        	
//        }if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_EQUALS)) {
//    		checkCollisionAndMove();
//        	moveCounter++;
//        }if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_MINUS)) {
//    		checkCollisionAndMove();
//        	moveCounter--;
//        }
        	
		
        
    public void checkCollisionAndMove(){
        handler.getWorld().playerLocation[xCoord][yCoord]=false;
        int x = xCoord;
        int y = yCoord;
        switch (direction){
            case "Left":
                if(xCoord==0){
                    kill();
                }else{
                    xCoord--;
                }
                break;
            case "Right":
                if(xCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                    kill();
                }else{
                    xCoord++;
                }
                break;
            case "Up":
                if(yCoord==0){
                    kill();
                }else{
                    yCoord--;
                }
                break;
            case "Down":
                if(yCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                    kill();
                }else{
                    yCoord++;
                }
                break;
        }
        handler.getWorld().playerLocation[xCoord][yCoord]=true;

        
        if(handler.getWorld().appleLocation[xCoord][yCoord]){
        	Eat();
        	currScore += Math.sqrt((2*currScore)+1);//cuando coma la manzana enseñe el score (Alondra) 
        //	currScore++; //(anthony) el score se estaba quedando en los 3.99 asi que lo modifique un poco
			}
                     
        
        if(!handler.getWorld().body.isEmpty()) {
            handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
            handler.getWorld().body.removeLast();
            handler.getWorld().body.addFirst(new Tail(x, y,handler));
            // basicamente, coge la ultima parte del snake (tail) y la mueve al "cuello" (1 antes del head) cuando
            //  se mueve, simulando o dando la ilusion de que el snake se esta "moviedo"
            // El "cuello" es donde la cabeza de la serpiente solia estar
   
            for (int i = 0; i < handler.getWorld().body.size() ; i++) { //manda el mensaje "Game Over" cuando se choca con el mismo
    			if (xCoord==handler.getWorld().body.get(i).x && yCoord==handler.getWorld().body.get(i).y){
    				if (i != handler.getWorld().body.size() -1) {
    					Game.GameStates.State.setState(handler.getGame().gameoverState); //llamando al state game over para cuando 
    																						//choque diga "Game over (Alondra)
    					
    				}
    			}
    		}
        }
       
    }
   
    public void render(Graphics g,Boolean[][] playeLocation){
        new Random();
        for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
            	
            	g.setFont(new Font("Comic Sans MS", Font.PLAIN , 19)); //(Anthony) cambie el font
            	g.setColor(Color.WHITE); //color del texto (Alondra)
            	g.drawString("Score: "+currScore,20, 20); //proyecta el score en el juego (Alondra)  
            	g.drawString("Length: "+length, 690, 20); //(anthony) demuestra el length de la serpiente
            	g.setColor(Color.GREEN); // (Anthony) cambie el color del snake de .WHITE a .GREEN
            	
                if(playeLocation[i][j]||handler.getWorld().appleLocation[i][j]){
                    g.fillRect((i*handler.getWorld().GridPixelsize),
                            (j*handler.getWorld().GridPixelsize),
                            handler.getWorld().GridPixelsize,
                            handler.getWorld().GridPixelsize);
                }

            }
        }


    }

    public void Eat(){
    	speedManager -= 5; // (anthony) - mi ultimo digito es 4 (entonces, 4 + 1 = 5)
    	//moveCounter += 5;
        length++;
        Tail tail= null;
        handler.getWorld().appleLocation[xCoord][yCoord]=false;
        handler.getWorld().appleOnBoard=false;
        
    	
    	
        switch (direction){
            case "Left":
                if( handler.getWorld().body.isEmpty()){
                    if(this.xCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail = new Tail(this.xCoord+1,this.yCoord,handler);
                    }else{
                        if(this.yCoord!=0){
                            tail = new Tail(this.xCoord,this.yCoord-1,handler);
                        }else{
                            tail =new Tail(this.xCoord,this.yCoord+1,handler);
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().x!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler);
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler);
                        }else{
                            tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler);

                        }
                    }

                }
                break;
            case "Right":
                if( handler.getWorld().body.isEmpty()){
                    if(this.xCoord!=0){
                        tail=new Tail(this.xCoord-1,this.yCoord,handler);
                    }else{
                        if(this.yCoord!=0){
                            tail=new Tail(this.xCoord,this.yCoord-1,handler);
                        }else{
                            tail=new Tail(this.xCoord,this.yCoord+1,handler);
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().x!=0){
                        tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                        }
                    }

                }
                break;
            case "Up":
                if( handler.getWorld().body.isEmpty()){
                    if(this.yCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=(new Tail(this.xCoord,this.yCoord+1,handler));
                    }else{
                        if(this.xCoord!=0){
                            tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().y!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                        }
                    }

                }
                break;
            case "Down":
                if( handler.getWorld().body.isEmpty()){
                    if(this.yCoord!=0){
                        tail=(new Tail(this.xCoord,this.yCoord-1,handler));
                    }else{
                        if(this.xCoord!=0){
                            tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                        } 
                    }
                }else{
                    if(handler.getWorld().body.getLast().y!=0){
                        tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                        }
                    }

                }
                break;
        }
        handler.getWorld().body.addLast(tail);
        handler.getWorld().playerLocation[tail.x][tail.y] = true;
    }

    public void kill(){
        length = 0;
        for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
                handler.getWorld().playerLocation[i][j]=false;
               
            }
        }
       
	}
    
    public boolean isJustAte() {
        return justAte;
    }

    public void setJustAte(boolean justAte) {
        this.justAte = justAte;
    }
}
