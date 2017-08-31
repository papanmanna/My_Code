import java.util.*;
public class Main {
	
	
public static void main(String []ar){
	Linked ob=new Linked();
	boolean flag=true;
	System.out.println("enter data end of -99");
	Scanner sc=new Scanner(System.in);
	while(flag)
	{
		int v=sc.nextInt();
		if(v==-99)
			flag=false;
		else
			ob.add(v);
	}
	ob.display();
	System.out.println("after reverse:");
	ob=ob.reverse();
	ob.display();
}
}
