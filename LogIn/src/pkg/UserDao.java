package pkg;
import java.sql.*;

public class UserDao {

	 final String DRIVER_NAME="com.mysql.jdbc.Driver";
	 final String URL="jdbc:mysql://localhost:3306/employees";
	 final String U_NAME="root";
	 final String PASSWORD="91221143";
	 Connection con=null;
	 Statement st=null;
	 PreparedStatement ps;
     ResultSet rs=null;
	UserDao()
	{
		con=null;
		st=null;
		rs=null;
		ps=null;
	}
	public  User getUser(User user) throws SQLException, ClassNotFoundException {
	
			String gmail=user.getGmail();
			String pass=user.getPass();
			System.out.println(gmail+" "+pass);
			String sql="select * from user where gmail='"+gmail+"'AND pass='"+pass+"'";	
			Class.forName("com.mysql.jdbc.Driver");			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","91221143");
			System.out.println("connected");
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()){
				System.out.println(rs);
				user.setValid(true);
				String name=rs.getString("name");
				int mob=rs.getInt("mob");
				user.setName(name);
				user.setMob(mob);
			}
			else{
				user.setValid(false);
				System.out.println("invalid");
			}
			rs.close();
			st.close();
			con.close();
			
		return user;
	}
	public int createUser(User user) throws ClassNotFoundException, SQLException {
		String sql="insert into user value(?,?,?,?)";	
		String sql1="select * from user where gmail='"+user.getGmail()+"'AND pass='"+user.getPass()+"'";	
		Class.forName("com.mysql.jdbc.Driver");			
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","91221143");
		System.out.println("connected");
		st=con.createStatement();
		rs=st.executeQuery(sql1);
		int count=0;
		if(rs.first())
		{
			count=0;
		}
		else{
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getMob());
			ps.setString(3, user.getPass());
			ps.setString(4, user.getGmail());
			count=ps.executeUpdate();
			ps.close();
		}
		rs.close();
		st.close();

		con.close();
		
		return count;
	}


}
