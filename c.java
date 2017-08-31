class c extends B
{
	void display()
	{	
		super.disp();
		System.out.println("hello from c");
	}
}
class C
{
	public static void main(String []sr)
	{
		c ob1=new c();
		ob1.display();
	}
}
	
