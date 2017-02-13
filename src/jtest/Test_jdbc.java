package jtest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Test_jdbc {
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		String user = "root";
		String pwd = "root";
		String myjdbc = "jdbc:mysql://localhost:3306/studb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection myConnection = DriverManager.getConnection(myjdbc,user,pwd);
		Statement myOperation =myConnection.createStatement();
		ResultSet rs = myOperation.executeQuery("select * from stuinfo");
		while(rs.next()){
			System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getInt("score"));
		}
		try{
			if (rs !=null)
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(myConnection!=null)
					myConnection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
		}
	}
}
