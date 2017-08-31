package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;

public class Dao {
	Connection con;
	Statement st;
	PreparedStatement pst;
	Dao()
	{
		con=null;
		st=null;
		pst=null;
	}
	public Emp getEmp(int i) throws Exception {
		Emp e=new Emp();
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","91221143");
		st=con.createStatement();
		String sql="select * from employee where id="+i;
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		e.id=rs.getInt("id");
		e.name=rs.getString("name");
		e.passwd=rs.getString("passwd");
		st.close();
		con.close();
		return e;
	}
	public void addEmp(Emp e2) throws Exception {
		String query="insert into employee value(?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","91221143");
		pst=con.prepareStatement(query);
		pst.setInt(1, e2.id);
		pst.setString(2, e2.name);
		pst.setString(3, e2.passwd);
		int count=pst.executeUpdate();
		System.out.println(count+" row affected");
		
	}

}
