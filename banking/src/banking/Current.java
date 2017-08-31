package banking;

public class Current extends Bank {
	
	public void deposit(int am)
	{
			int x=this.getbaln();
			x=x+am;
			setbaln(x);
			System.out.println("your current balance is:"+getbaln() );
			
	}
	public void withdraw(int am)
	{
		int x=this.getbaln();
		x=x-am;
		setbaln(x);
		System.out.println("your current balance is:"+getbaln());
		
	}
}
