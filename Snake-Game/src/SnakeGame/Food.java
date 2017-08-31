package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;

public class Food {

	private int x,y,score;
	SnakeBody sb;
	private int time= 20;
	Snake music;
	Food(Snake main)
	{
		x=(int)(Math.random()*795);
		y=(int)(Math.random()*595);
		score=0;
		music=main;//for music;
		
		
	}
	void setPosition()
	{
		x=(int)(Math.random()*795);
		y=(int)(Math.random()*595);
	}
	void makeFood(SnakeBody s)
	{
		 Point head=s.snake.get(0);
		 if(head.getx()+2>=x-1 && head.getx()+2<=x+7)
		 {
			 if(head.gety()+2>=y-1 && head.gety()+2<=y+7){
			 setPosition();
			 s.setincrement(true);
			 score++;
			music.ad.play();
			 }
		 }
		
		 sb=s;
	}
	void paint(Graphics g)
	{
		
		if(!sb.getisover()){
		g.setColor(Color.green);
		g.fillRect(x, y, 6,6);
		}
	}
	public int getscore() {
		
		return score;
	}
	public long gettime() {
		
		return time;
	}
}
