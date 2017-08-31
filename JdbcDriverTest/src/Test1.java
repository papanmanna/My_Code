import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Test1 {

	public static void main(String[] args)  {
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}catch(ClassNotFoundException c)
		{
			c.printStackTrace();
		}
		Enumeration e=DriverManager.getDrivers();
		while(e.hasMoreElements())
		{
			Driver d=(Driver)e.nextElement();
			System.out.println(d.getClass().getName());
		}
	
	}

}
