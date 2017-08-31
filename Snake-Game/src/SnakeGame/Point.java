package SnakeGame;

public class Point {
	private int x,y;
	Point()
	{
		x=0;y=0;
	}
	Point(int a,int b)
	{
		x=a;y=b;
	}
	void setx(int a)
	{
		x=a;
	}
	void sety(int a)
	{
		y=a;
	}
	int getx()
	{
		return x;
	}
	int gety()
	{
		return y;
	}
}
