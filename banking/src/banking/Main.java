package banking;
import java.lang.*;
import java.util.*;
public class Main {
	Current c[]=new Current[10];
	 Savings s[]=new Savings[10];
	static int count1=0,count2=0,p;
	 Scanner sc=new Scanner(System.in);
	
	public void menu1()
	{
		System.out.println("1:a/c opening\n2:deposit\n3:display\n4:withdraw\n5:exit");

	}
	public int generateid()
	{
		Random r=new Random();
		while(true){
		 int k = r.nextInt();
		 k = (k + 1) * 9999;
		 if(k>9999 && k<99999  && check(k))
			 return k;
		}
		 
	}
	boolean check(int k){
		for(int i=0;i<count1;i++)
		{
			if(k==c[i].getid())
				return false;
		}
		for(int i=0;i<count2;i++)
		{
			if(k==s[i].getid())
				return false;
		}
		return true;
	}
	public void withdraw()
	{
		System.out.println("1:current\n2:savings\n");
		int i=sc.nextInt();
		try{
			if(i==1)
			{
				System.out.println("enter id:");
				int idd=sc.nextInt();
				for(int k=0;k<count1;k++)
				{
					if(c[k].getid()==idd){
						System.out.println("enter balance:");
				//Scanner sc=new Scanner(System.in);
						int b=sc.nextInt();
						if(b<=c[k].getbaln()){
							c[k].withdraw(b);
							return;
						}
						else
							throw new MyException("Insufficient Balance");
					}
				}
				System.out.println("you enterd wrong id");
			}
			else{
				System.out.println("enter id:");
				int idd=sc.nextInt();
				for(int k=0;k<count2;k++)
				{
					if(s[k].getid()==idd){
						System.out.println("enter balance:");
				//Scanner sc=new Scanner(System.in);
						int b=sc.nextInt();
						if(b<=s[k].getbaln()){
							s[k].withdraw(b);
							return;
						}
						else
							throw new MyException("Insufficient Balance");
					}
				}
				System.out.println("you enterd wrong id");
			}
			
		}catch(MyException ob)
		{
			System.out.println(ob.getMessage());
		}
		
	}
	public void a_cOpening()
	{
		
		System.out.println("1:current\n2:savings\n");
		//Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		if(i==1)
		{
			System.out.println("enter balance:");
			//Scanner sc=new Scanner(System.in);
			int j=sc.nextInt();
			c[count1]=new Current();
			c[count1].setbaln(j);
			c[count1].setid(generateid());
			
			System.out.println("your a/c id is: "+c[count1].getid());
	
			count1++;
		}
		else
		{
			System.out.println("enter balance:");
			//Scanner sc=new Scanner(System.in);
			int j=sc.nextInt();
		
			s[count2]=new Savings();
			s[count2].setbaln(j);
			s[count2].setid(generateid());
		
			System.out.println("your a/c id is: "+s[count2].getid());
	
			count2++;
		}
		
		
	}
	public void deposit()
	{
		System.out.println("1:current\n2:savings\n");
		//Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		if(i==1)
		{
			System.out.println("enter id:");
			int idd=sc.nextInt();
			for(int k=0;k<=count1;k++)
			{
				if(c[k].getid()==idd){
					System.out.println("enter balance:");
			//Scanner sc=new Scanner(System.in);
					int b=sc.nextInt();
					c[k].deposit( b);
					return;
				}
			}
			System.out.println("you enterd wrong id");
		}
		else{
			System.out.println("enter id:");
			int idd=sc.nextInt();
			for(int k=0;k<=count2;k++)
			{
				if(s[k].getid()==idd){
					System.out.println("enter balance:");
			//Scanner sc=new Scanner(System.in);
					int b=sc.nextInt();
					s[k].deposit(b);
					return;
				}
			}
			System.out.println("you enterd wrong id");
		}
	}
	public void display(){
		System.out.println("1:current\n2:savings\n");
		//Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		if(i==1)
		{
			System.out.println("enter id:");
			int idd=sc.nextInt();
			for(int k=0;k<=count1;k++)
			{
				if(c[k].getid()==idd){
				System.out.println("you ac balance: "+c[k].getbaln());
				return;
				}
			}
		}
		else{
			System.out.println("enter id:");
			int idd=sc.nextInt();
			for(int k=0;k<=count1;k++)
			{
				if(s[k].getid()==idd){
				System.out.println("you ac balance: "+s[k].getbaln());
				return;
				}
			}
		}
		System.out.println("you entered wrong id");
	}
	public static void main(String[] args) {
		int i;
		boolean quit=true;
		Main ob=new Main();
		System.out.println("enter your choice");
		Scanner s=new Scanner(System.in);
		while(quit){
		ob.menu1();
		i=s.nextInt();
		switch(i)
		{
		case 1:
			try{
				if(count1+count2>=3){
					throw new MyException("out of creation");
				}
				ob.a_cOpening();
				}catch(MyException ob1){
					System.out.println(ob1.getMessage());
				}
			break;
		case 2:
			ob.deposit();
			break;
		case 3:
			ob.display();
			break;
		case 4:
			ob.withdraw();
			break;
		case 5:
			quit=false;
			System.out.println("Thank You");
			break;
		}
		}
		
	}

}
