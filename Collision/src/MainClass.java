import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;



public class MainClass extends Applet implements Runnable  {
	
	private boolean running;
	Thread t;
	Ball b1,b2;
	public void init(){
		running=true;
		setSize(1366,788);
		setBackground(Color.gray);
		//setForeground(Color.red);
		b1=new Ball(150,100,100,100,Color.red);
		b2=new Ball(450,400,100,100,Color.green);
	}
	public void start(){
		t=new Thread(this);
		t.start();
	}
	public void stop(){running =false;}
	public void destroy(){}
	

	public void run() {
			while(running)
			{
			
				repaint();
				
				b1.update(this);
				b2.update(this);
				check(b1,b2);
				try{
					t.sleep(10);
				}catch(InterruptedException e){}
			}
	}
	public void check(Ball a, Ball b) {
		if((b.getX()-a.getX()<=100)&&(a.getY()-b.getY()<=100)&&(0<=b.getX()-a.getX())&&(0<=a.getY()-b.getY()))
		{
			a.setVX(-4);
			b.setVX(5);
			a.setVY(6);
			b.setVY(-5);
			
			
		}
		else if((b.getX()-a.getX()<=100)&&(b.getY()-a.getY()<=100)&&(0<=b.getX()-a.getX())&&(0<=b.getY()-a.getY()))
		{
			a.setVX(-5);
			b.setVX(4);
			a.setVY(-5);
			b.setVY(6);
		}
		else if((a.getX()-b.getX()<=100)&&(b.getY()-a.getY()<=100)&&(0<=a.getX()-b.getX())&&(0<=b.getY()-a.getY()))
		{
			b.setVY(-3);
			a.setVY(5);
			b.setVX(5);
			a.setVX(-5);
			
		}
		else if((b.getX()-a.getX()<=100)&&(b.getY()-a.getY()<=100)&&(0<=b.getX()-a.getX())&&(0<=b.getY()-a.getY()))
		{
			b.setVY(5);
			a.setVY(-5);
			b.setVX(-5);
			a.setVX(5);
			
		}
		
		
		
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
    	/*Graphics2D g2=(Graphics2D) g;
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);*/
		b1.paint(g);
		b2.paint(g);
	}

}
