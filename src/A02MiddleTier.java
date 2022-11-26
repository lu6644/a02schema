import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Date;

public class A02MiddleTier {
	//This class will contain your code for interacting with Database, acquire the query result and display it in the GUI text area.
	String url = "jdbc:mysql://localhost:3306/a02schema?useSSL=false&serverTimezone=UTC";
	String username = "root";
	String password = "Abby6!644";
	Connection con = null;



	public A02MiddleTier(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public String insertEventConference(String name, String Date){
		java.util.Date t = new java.util.Date();
		
		Date evdate;
	}

	public static void main(String args[]) throws SQLException, IOException{
		A02MiddleTier a2m= new A02MiddleTier();
	}
}
