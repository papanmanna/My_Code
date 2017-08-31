import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.List;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Bounce extends JPanel
{
	int X,Y,X1=200,Y1=300,dx=1,dy=1,dx1=1,dy1=1,height,width;
    static JFrame jf;
	java.util.Timer move;

	Bounce(int x,int y,int w,int h){
	
		X=x;
		Y=y;
		width=w;
		height=h;
		setBackground(new Color(171,69,236 ));
		setForeground(new Color(124,238,246));
		
		move=new java.util.Timer();
		move.scheduleAtFixedRate(new TimerTask()
			{
			public void run()
			{
				if(X<0)
					dx=2;
				if(X>=getWidth()-20)
					dx=-1;
				if(Y<0)
					dy=2;
				if(Y>=getHeight()-20)
					dy=-1;
				
				if(X1<0)
					dx1=3;
				if(X1>=getWidth()-20)
					dx1=-2;
				if(Y1<0)
					dy1=3;
				if(Y1>=getHeight()-20)
					dy1=-2;
				
				X+=dx;
				Y+=dy;
				X1+=dx1;
				Y1+=dy1;
				repaint();
			}
			},0,5);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
    	/*Graphics2D g2=(Graphics2D) g;
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);*/
    	g.fillOval(X,Y,width,height);
    	g.fillOval(X1,Y1,70,70);
    
	}
	
	
	
	public static void main(String []args)
	{
		jf=new JFrame();  
		Bounce w=new Bounce(100,100,70,70);	
		jf.add(w);
		jf.setVisible(true);
		jf.setBounds(0, 0, 700, 600);
	}
}

	