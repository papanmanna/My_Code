package controlobject;
public class  ControlOb
{	
	private static ControlOb ob;
	public static int count=0;
	private  ControlOb()
	{
		count++;
	}
	public static ControlOb myMethod()
	{
		if(count<4)
		{
			ob=new ControlOb();
		}
		else
		{
			System.out.println("now you cannot create any object");
		}
		return ob;
	}
}
