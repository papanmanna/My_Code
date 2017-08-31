

class AA{

	public static void main(String args[]){
	MulT t1=new MulT(5,"one",10);
	MulT t2=new MulT(6,"two",10);
    Thread.currentThread().setName("papan");
	/*try{
		Thread.sleep(100);
	}catch(Exception ob)
	{
		System.out.println(ob.getMessage());
	}*/
    try{
    	//System.out.println(t1.t.isAlive());
    
    	t1.t.join();
    	
    	System.out.println(t1.t.isAlive());	
    	t2.t.join();
    	//System.out.println(t2.t.isAlive());	
    }catch(InterruptedException ob)
    {
    	System.out.println(ob.getMessage());
    }
	System.out.println(Thread.currentThread().getName() +"  ratio->  "+t1.s +":"+t2.s);
	//System.out.println(t1.t.isAlive());	
	}

}