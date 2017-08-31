
public class MulT implements Runnable{
	int s=1,n;
	Thread t;
	//Thread t=Thread.currentThread();
	MulT(int i,String st,int p)
	{
		n=i;
		t=new Thread(this,st);
		t.setPriority(p);
		t.start();
	}
	public void run()
	{
		for(int i=1;i<=n;i++)
			s=s*i;
		System.out.println(t.getName()+" :"+s);
	}
	
}
