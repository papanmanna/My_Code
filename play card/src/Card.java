
public class Card {

	int name;
	int value;
	int priority;
	String strimage;
	Card()
	{
		name=0;
		value=0;
		priority=0;
		strimage=null;
	}
	public Card(int i, int j, String s1) {
		name=j;
		value=i;
		strimage=s1;
		if(value>10)
		{
			priority=value-10;
		}
	//	System.out.println(name+"--"+value);
	}
	
	
}
