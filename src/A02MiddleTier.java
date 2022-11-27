import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class A02MiddleTier {
	//This class will contain your code for interacting with Database, acquire the query result and display it in the GUI text area.
	String url = "jdbc:mysql://localhost:3306/a02schema?useSSL=false&serverTimezone=UTC";
	String username = "root";
	String password = "123456";
	Connection con = null;
	int id = 0;



	public A02MiddleTier(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public String insertEventConference(String name, String date) throws SQLException {
		id++;
		String eventName = name;
		String eventWebLink = null;
		String CFPText = null;
		String city =null;
		String country = null;
		Date evdate = Date.valueOf(date);

		//Prepare sql statement
		String stmt1 = "insert into event(ID,Name) values(?,?)";
		try {
			PreparedStatement p1 = con.prepareStatement(stmt1) ;
			p1.clearParameters() ;
			p1.setInt(1, id);
			p1.setString(2, eventName);
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String stmt2 = "insert into eventconference(EventID,EvDate) values(?,?)";
		try {
			PreparedStatement p2 = con.prepareStatement(stmt2) ;
			p2.clearParameters() ;
			p2.setInt(1, id);
			p2.setDate(2, evdate);
			p2.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String stmt3 = "select * from event";
		try {
			PreparedStatement p3 = con.prepareStatement(stmt3);
			ResultSet r = p3.executeQuery();
			sb.append("Event\nID\tName\tEventWebLink\tCFPText\n");
			while (r.next()){
				sb.append(String.format("%d\t%s\t%s\t%s\n",r.getInt("ID"),r.getString("Name"),r.getString("EventWebLink"),r.getString("CFPText")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

		String stmt4 = "select * from eventconference";
		try {
			PreparedStatement p4 = con.prepareStatement(stmt4);
			ResultSet r = p4.executeQuery();
			sb.append("EventConference\nEventID\tCity\tCountry\tEvDate\n");
			while (r.next()){
				sb.append(String.format("%d\t%s\t%s\t%s\n",r.getInt("EventID"),r.getString("City"),r.getString("Country"),r.getDate("Evdate").toString()));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		sb.append("\n");

		return sb.toString();
	}
	
	public String insertEventJournal(String name, String jname) throws SQLException{
		this.id++;
		String eventName = name;
		String eventWebLink = null;
		String CFPText = null;
		String publisher = null;
		String stmt1 = "insert into event(ID,Name) values(?,?)";
		try {
			PreparedStatement st1 = con.prepareStatement(stmt1);
			st1.clearParameters();
			st1.setInt(1, id);
			st1.setString(2, eventName);
			st1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String stmt2 = "insert into eventjournal(EventID,JournalName) values(?,?)";
		try {
			PreparedStatement st2 = con.prepareStatement(stmt2);
			st2.clearParameters();
			st2.setInt(1, id);
			st2.setString(2, jname);
			st2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		String stmt3 = "select * from event";
		try {
			PreparedStatement st3 = con.prepareStatement(stmt3);
			ResultSet r = st3.executeQuery();
			sb.append("Event\nID\tName\tEventWebLink\tCFPText\n");
			while (r.next()){
				sb.append(String.format("%d\t%s\t%s\t%s\n",r.getInt("ID"),r.getString("Name"),r.getString("EventWebLink"),r.getString("CFPText")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

		String stmt4 = "select * from eventjournal";
		try {
			PreparedStatement st4 = con.prepareStatement(stmt4);
			ResultSet r = st4.executeQuery();
			sb.append("EventJournal\nEventID\tJournalName\tPublisher\n");
			while (r.next()){
				sb.append(String.format("%d\t%s\t%s\n",r.getInt("EventID"),r.getString("JournalName"),r.getString("Publisher")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public String insertEventBook(String name){
		this.id++;
		String eventName = name;
		String eventWebLink = null;
		String CFPText = null;
		String publisher = null;
		String stmt1 = "insert into event(ID,Name) values(?,?)";
		try {
			PreparedStatement st1 = con.prepareStatement(stmt1);
			st1.clearParameters();
			st1.setInt(1, id);
			st1.setString(2, eventName);
			st1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String stmt2 = "insert into eventbook(EventID) values(?)";
		try {
			PreparedStatement st2 = con.prepareStatement(stmt2);
			st2.clearParameters();
			st2.setInt(1, id);
			st2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		String stmt3 = "select * from event";
		try {
			PreparedStatement st3 = con.prepareStatement(stmt3);
			ResultSet r = st3.executeQuery();
			sb.append("Event\nID\tName\tEventWebLink\tCFPText\n");
			while (r.next()){
				sb.append(String.format("%d\t%s\t%s\t%s\n",r.getInt("ID"),r.getString("Name"),r.getString("EventWebLink"),r.getString("CFPText")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

		String stmt4 = "select * from eventbook";
		try {
			PreparedStatement st4 = con.prepareStatement(stmt4);
			ResultSet r = st4.executeQuery();
			sb.append("EventBook\nEventID\tPublisher\n");
			while (r.next()){
				sb.append(String.format("%d\t%s\n",r.getInt("EventID"),r.getString("Publisher")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		sb.append("\n");
		return sb.toString();

	}


	public static void main(String args[]) throws SQLException, IOException{
		A02MiddleTier a2m= new A02MiddleTier();
	}
}
