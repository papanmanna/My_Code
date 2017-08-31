package multithread;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fact f1=new Fact("one",5);
		Fact f2=new Fact("two",6);
		
		Thread t1=new Thread(f1);
		Thread t2=new Thread(f2);
		t2.setPriority(10);
		try{
			
			t1.start();
		//	t2.join();
			t2.start();
		//	Thread.sleep(1000);
			//System.out.println(t1.getPriority()+" "+t2.getPriority()+" "+Thread.currentThread().getPriority());
		
		//	Thread.sleep(1000);
			
		}catch(Exception ob){}
	}

}
