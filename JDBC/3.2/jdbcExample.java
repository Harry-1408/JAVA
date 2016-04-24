import java.sql.*;

public class jdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Harsh1408");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO student(name,roll_no,branch) VALUES('Aarsh',5,'cse')");
			stmt.executeUpdate("INSERT INTO student(name,roll_no,branch) VALUES('Milan',70,'cse')");
			stmt.executeUpdate("INSERT INTO student(name,roll_no,branch) VALUES('Ajay',000,'cse')");
			System.out.println("Data Successfully Entered!");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
