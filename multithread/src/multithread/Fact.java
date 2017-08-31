package multithread;
import java.util.*;
import java.lang.*;
public class Fact implements Runnable {
	
	
	int s=1;

	Fact(String ob,int i)
	{
		//t=new Thread(this,ob);
		s=i;
	
	}
	synchronized public void run()
	{
		int s1=1;
		for(int i=1;i<=s;i++)
			s1=s1*i;
		System.out.println(s1);
		
	}
}
