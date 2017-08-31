package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		List c=new ArrayList();
		c.add(5);
		c.add(3);
		c.add(1);
		c.add("papan");
		
	
		
		//System.out.println(c[0]);
		for(Object i:c)
			System.out.println(i);
		
		
		ArrayList<Integer> li=new ArrayList<Integer>();
		li.add(5);
		li.add(3);
		li.add(1);
		li.add(1,2);
		li.remove(2);
		//Collections.sort(li);
			System.out.println("contains of list :"+li);
		
		
		
		Collection col=new ArrayList();
		col.addAll(li);
		for(Object i:col)
			System.out.println(i);
		
		
		
		
		//sum of the list
		Object[] a=li.toArray();
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum+=((Integer) a[i]).intValue();////type casting a[]
		
		System.out.println("sum: "+sum);
		
		
	
	
	
	
	//	if(col.equals(i))
			
			
	}

}
