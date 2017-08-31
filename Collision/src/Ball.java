import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class Ball {
	private int X,Y,WIDTH,HEIGHT,VX=5,VY=5;
	Color c;
	Ball(int x,int y,int w,int h,Color col)
	{
		X=x;
		Y=y;
		WIDTH=w;
		HEIGHT=h;
		c=col;
	}
	public void update(MainClass mc)
	{
			
				
				if(X<0)
					VX=5;
				if(X>=mc.getWidth()-20)
					VX=-4;
				if(Y<0)
					VY=4;
				if(Y>=mc.getHeight()-20)
					VY=-6;
				X+=VX;
				Y+=VY;
				
			//	mc.repaint();
	}
	
	
	public void paint(Graphics g){
		g.setColor(c);
		g.fillOval(X, Y, WIDTH,HEIGHT);
	}
	public int getX() {
	
		return X;
	}
	public void setVX(int i) {
		
		VX=i;
	}
	public void setVY(int i) {
		
		VY=i;
	}
	public int getY() {
		
		return Y;
	}
}
