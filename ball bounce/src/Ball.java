import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.applet.*;



//<APPLET CODE=Main HEIGHT=500 WIDTH=700></APPLET>


 public class Ball extends Applet implements KeyListener{
	 java.util.Timer move;
	int x=10,y=10,dx=0,dy=0;

	 public void init(){
		 this.addKeyListener(this);
		 setSize(700,500);
		setBackground(Color.blue);
		setForeground(Color.red);
	 }
    public void paint(Graphics g){
    	super.paint(g);
    	Graphics2D g2=(Graphics2D) g;
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	if(!(x>getWidth()-40 || y>getHeight()-40 || x<0||y<0)){
    		x+=dx;
          y+=dy;
    	  }
    
          
    	g2.fillOval(x,y,20,20);
    	try{
    		Thread.sleep(100);
    		
    		repaint();
    	}catch(InterruptedException e){}
    }
	public void keyPressed(KeyEvent e){
		  int code = e.getKeyCode();
		  dx=0;dy=0;
          if (code == KeyEvent.VK_UP){
  			if(y>0)
  				dy=-10;		
          }

          if (code == KeyEvent.VK_DOWN){
              if(y<getHeight()-40)
  				dy=10;
               			
          }

          if (code == KeyEvent.VK_LEFT){
              if(x>0)
  				dx=-10;            
          }

          if (code == KeyEvent.VK_RIGHT){
              if(x<getWidth()-40)
  				dx=10;
  		
          }
        x+=dx;
      	y+=dy;
      	//repaint();
    }


    public void keyTyped(KeyEvent e){
    	
    }

    public void keyReleased(KeyEvent e){
  	  int code = e.getKeyCode();
	  dx=0;dy=0;
      if (code == KeyEvent.VK_UP){
			if(y>0)
				dy=-10;			
      }

      if (code == KeyEvent.VK_DOWN){
          if(y<getHeight()-40)
				dy=10;
                       
			
      }

      if (code == KeyEvent.VK_LEFT){
          if(x>0)
				dx=-10;            

      }

      if (code == KeyEvent.VK_RIGHT){
          if(x<getWidth()-40)
				dx=10;
	
      }
      repaint();

   }
 }

	


