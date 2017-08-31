package banking;

public abstract class Bank {
	private int id,baln;
	abstract void deposit(int b);
	abstract void withdraw(int am); 
	public int getid()
	{
		return id;
	}
	public int getbaln()
	{
		return baln;
	}
	public void setbaln(int x)
	{
		baln=x;
	}
	public void setid(int x)
	{
		 id=x;
	}
	
}
