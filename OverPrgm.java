class OverLoading
	{
	int width,height,length;
	OverLoading(int a,int b,int c)
		{
		width=a;
		length=b;
		height=c;
		}
	OverLoading(int a)
		{
		width=height=length=a;	
		}
	 OverLoading()
                {
                width=height=length=-1;
                }

	OverLoading createCube(OverLoading ob)
		{
		int a;
		if(ob.length>ob.height && ob.length>ob.width)
			 a=ob.length;
		else if(ob.width>ob.length && ob.width>ob.height)
			a=ob.width;
		else
			 a=ob.height;
		OverLoading temp=new OverLoading(a);
		return temp;
		}
	int volume()
		{
		return width*length*height;
		}
	}
class OverPrgm
	{
	public static void main(String []ar)
		{
		OverLoading ob=new OverLoading(10,5,2);
		System.out.println("volume = "+ob.volume());
		OverLoading ob1=new OverLoading();
		System.out.println("volume = "+ob1.volume());
		ob1=ob.createCube(ob);
		System.out.println("volume = "+ob1.volume());
		}
	}

				

