class  ControlOb
{	
	public int i;
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
			ob=null;
		}
		return ob;
	}
}
class ObjLimit
{
	public static void main(String []str)
	{
		ControlOb ob1=ControlOb.myMethod();
		ControlOb ob2=ControlOb.myMethod();
		ControlOb ob3=ControlOb.myMethod();
		ControlOb ob4=ControlOb.myMethod();
		ControlOb ob5=ControlOb.myMethod();
		ControlOb ob6=ControlOb.myMethod();
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob3);
		System.out.println(ob4);
		System.out.println(ob5);
		System.out.println(ob6);

	}
}
