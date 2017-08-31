package SnakeGame;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*<applet code=Snake
width=120 height=120>
</applet>*/


public class Snake extends Applet implements Runnable,KeyListener  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean running;
	Thread t;
	SnakeBody s;
	AudioClip ad;
	Food food;
	
	public void init(){
		this.addKeyListener(this);
		s=new SnakeBody();
		food=new Food(this);
		ad = getAudioClip(getDocumentBase(), "sn.au");
	//	ad.play();
		running=true;
	
		resize(800,600);
		setBackground(Color.red);
		setLayout(new BorderLayout());
		//setForeground(Color.red);
		
	}
	public void start(){
		t=new Thread(this);
		t.start();
	}
	public void stop(){running =false;}
	public void destroy(){running =false;}
	

	public void run() {
			while(running)
			{
				if(!s.getisover()){
				
					food.makeFood(s);
					s.update();
					update();
					
				}
					repaint();
				
					
				
				try{
					Thread.sleep(food.gettime());
				}catch(InterruptedException e){}
			}
	}

	public void paint(Graphics g)
	{
		super.paint(g);
    	/*Graphics2D g2=(Graphics2D) g;
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);*/
	
	
		
		
		if(!s.getisover())
		{
			s.paint(g);
			food.paint(g);
		}
		else
		{
			endGame(g);
		
		}
	}
	private void endGame(Graphics g) {
		Font f = new Font("Comic Sans MS", Font.BOLD, 30);
        g.setFont(f);
		g.setColor(Color.white);
		g.drawString("**** Game Over ****", 200, 300);
		g.setColor(Color.yellow);
		g.drawString("@ Thank You @", 250, 400);
		g.setColor(Color.green);
		g.drawString("!!! Better Luck Next Time !!!", 150, 500);
		g.drawString("Your Score : "+food.getscore(), 500, 50);
		
	}
	public void update()
	{
		Point temp=s.snake.get(0);
		if(temp.getx()>getWidth() || temp.getx()<0)
		{
			s.setisover(true);
		}
		else if(temp.gety()>getHeight() || temp.gety()<0)
		{
			s.setisover(true);
		}
		else
			s.setisover(s.getcollision());
		
		
	}
	
	public void keyPressed(KeyEvent k) {
		if(!s.getismoving())
		{
			if(k.getKeyCode()==KeyEvent.VK_UP || k.getKeyCode()==KeyEvent.VK_DOWN || k.getKeyCode()==KeyEvent.VK_RIGHT || k.getKeyCode()==KeyEvent.VK_LEFT)
			{
				s.setismoving(true);
			}
		}
		if(k.getKeyCode()==KeyEvent.VK_UP)
		{
			if(s.getydir()!=1){
			s.setxdir(0);
			s.setydir(-1);
			}
			
		}
		if(k.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(s.getydir()!=-1){
			s.setxdir(0);
			s.setydir(1);
			}
		}
		if(k.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(s.getxdir()!=1){
			s.setxdir(-1);
			s.setydir(0);
			}
		}
		if(k.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(s.getxdir()!=-1){
			s.setxdir(1);
			s.setydir(0);
			}
		}
		
		
	}
	public void keyReleased(KeyEvent k) {
		
		
	}	
	public void keyTyped(KeyEvent k) {
		
		
	}

}
