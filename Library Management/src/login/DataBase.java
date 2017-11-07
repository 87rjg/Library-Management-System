package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_e6bfe1d098ba7c4?reconnect=true","b3306b354cd4b7","91125e51");
		}catch(Exception e){System.out.println("Connection problem"+e);}
		return con;
	}
}