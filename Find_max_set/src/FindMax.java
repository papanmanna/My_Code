import java.util.Scanner;

public class FindMax {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		sc.close();
		String sol=null;
		int max=-1;
		for(int i=0;i<s1.length();i++)
		{
			for(int j=0;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					int count=findLength(s1,s2,i,j);
					if(max<count)
					{
						max=count;
						 sol=s1.substring(i,i+count);
					}
					
				}
			}
		}
		System.out.println(sol+" : "+max);
		
	}

	public static int findLength(String s1, String s2, int i, int j) {
		int count=0;
		while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j))
		{
			count++;
			i++;j++;
		
		}
		return count;
	}
}
