import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main extends JPanel implements Runnable {
   
	Box b;
	private static boolean GAMEOVER;	
	Thread  t;
	
	Main()
	{
		setPreferredSize(new Dimension(400,500));
		GAMEOVER=true;
	}
	public void start()
	{
		if(GAMEOVER){
		 t=new Thread(this);
		 GAMEOVER=false;
		 t.start();
		 b=new Box();
		}
	}
	public void stop()
	{
		
	}
	
	

    public void paintComponent(Graphics g) {
      //  super.paint(g);
        g.setColor(Color.red);
		g.fillRect(145,300, 80, 80);
    }


	public void run() {
	
		 while(!GAMEOVER)
		 {
			repaint();
		 }
	}
	  public static void main(String[] args) throws InterruptedException {

	        JFrame frame = new JFrame("Sample Frame");
	        Main game = new Main();
	        frame.setLayout(new BorderLayout());
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(game);
	        frame.pack();
	        frame.getContentPane().setBackground(Color.BLACK);
	        frame.setVisible(true);
	      
	    }

}