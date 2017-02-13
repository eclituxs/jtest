package jtest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		Connection conn = null;
		String user ="root";
		String pwd = "root";
		String myjdbc = "jdbc:mysql://localhost:3306/studb";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ce){
			System.out.println(ce);
		}
		try{
			conn = DriverManager.getConnection(myjdbc,user,pwd);
		}catch(SQLException ce){
			System.out.println(ce);
		}
		return conn;
	}
}
