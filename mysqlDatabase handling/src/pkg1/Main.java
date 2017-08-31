package pkg1;

import java.sql.SQLException;
import java.sql.*;


public class Main {

	
	public static void main(String[] args)  {
		
		Dao d=new Dao();
		try{
		//Emp e1=d.getEmp(2);
	//	System.out.println(e1.id+" "+e1.name+" "+e1.passwd);
		
		Emp e2=new Emp(5,"Archana","pass");
		d.addEmp(e2);
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
