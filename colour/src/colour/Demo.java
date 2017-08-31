package colour;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Demo extends Applet implements Runnable{

	boolean running;
	int r,g,b;
	Color col;
	Thread t;
	public void init(){
		t=new Thread(this);
		running=true;
		setSize(500,400);
	}
	public void start(){t.start();}
	public void stop(){}
	public void update(){
		
		Random rd=new Random();
		r=rd.nextInt(255);
		g=rd.nextInt(255);
		b=rd.nextInt(255);
		col=new Color(r,g,b);
		setBackground(col);
	}
	
	public void run() {
	while(running)
	{
		try{
			Thread.sleep(500);
			update();
			
		}catch(Exception ob){}
	}
		
	}


}
