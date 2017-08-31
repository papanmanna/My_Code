
package SnakeGame;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SnakeBody {
	private int xdir,ydir;
	List<Point> snake;
	private boolean ismoving,isover,increment;
	final int length=40,startx=250,starty=150;
	SnakeBody()
	{
		xdir=0;ydir=0;
		ismoving=false;
		isover=false;
		increment=false;
		snake=new ArrayList<Point>();
		snake.add(new Point(startx,starty));
		for(int i=1;i<=length;i++)
		{
			snake.add(new Point(startx-(4*i),starty));
		}
		
	}
	public void paint(Graphics g)
	{
		
			g.setColor(Color.black);
			for(Point p : snake)
			g.fillRect(p.getx(), p.gety(),4,4);
			increment=false;
		
	
	}
	
	public void update()
	{
		Point last=snake.get(snake.size()-1);
		if(ismoving){
		Point temp=snake.get(0);
		//Point last=snake.get(snake.size()-1);
		
		snake.set(0, new Point(temp.getx()+(4*xdir),temp.gety()+(4*ydir)));
		for(int i=snake.size()-1;i>0;i--)
		{
			snake.set(i,snake.get(i-1));
		}
		}
		if(increment)
		{
			
			snake.add(last);
			snake.add(last);
			snake.add(last);
			snake.add(last);
			snake.add(last);
		}
		
	}
	public void setxdir(int i) {
		xdir=i;
	}
	public void setydir(int i) {
		ydir=i;
		
	}
	public boolean getismoving() {
		
		return ismoving;
	}
	public void setismoving(boolean b) {
		ismoving=b;
		
	}
	public int getxdir() {
		
		return xdir;
	}
	public int getydir() {
		
		return ydir;
	}
	public void setisover(boolean b) {
		isover=b;
		
	}
	public boolean getisover() {
	
		return isover;
	}
	public boolean getcollision() {
		Point temp=snake.get(0);
		for(int i=snake.size()-1;i>1;i--)
		{
			Point p=snake.get(i);
			if(p.getx()==temp.getx() && p.gety()==temp.gety())
				return true;
		}
			
		return false;
	}
	public void setincrement(boolean b) {
		increment=b;
		
	}
	

}
