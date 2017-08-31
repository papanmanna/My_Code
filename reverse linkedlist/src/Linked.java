
public class Linked {
	int v;
	Linked next;
	Linked()
	{
		v=-999;
		next=null;
	}
	Linked(int m)
	{
		v=m;
		next=null;
	}
	void add(int m)
	{
		Linked ptr;
		for(ptr=this;ptr.next!=null;ptr=ptr.next);
		ptr.next=new Linked(m);
			
	}
	Linked reverse()
	{
		Linked temp;
		Linked ptr=this,prev=this;
		temp=ptr.next;
		while(temp!=null)
		{
			ptr.next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=ptr.next;
		}
		return prev;
	}
	void display()
	{
		Linked ptr=this;
		while(ptr!=null)
		{
			if(ptr.v!=-999)
			System.out.print(ptr.v+" ");
			ptr=ptr.next;
		}
		System.out.println();
	}
	
}
