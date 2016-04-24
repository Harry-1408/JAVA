import java.sql.*;

public class jdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Harsh1408");
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			String SQL = "INSERT INTO student(name,roll_no,branch) VALUES('Harsh',026,'cse')";
			stmt.addBatch(SQL);
			String SQLONE = "INSERT INTO student(name,roll_no,branch) VALUES('Parth',030,'cse')";
			stmt.addBatch(SQLONE);
			String SQLTWO = "INSERT INTO student(name,roll_no,branch) VALUES('Palak',007,'cse')";
			stmt.addBatch(SQLTWO);
			stmt.executeBatch();
			System.out.println("Data Successfully Entered!");
			conn.commit();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
