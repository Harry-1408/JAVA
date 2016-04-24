import java.sql.*;

public class jdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Harsh1408");
			String SQL = "INSERT INTO student(name,roll_no,branch) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString( 1, "Harsh");
			pstmt.setInt( 2,26);
			pstmt.setString( 3,"cse");
			pstmt.executeUpdate();

			pstmt.setString( 1,"Palak");
			pstmt.setInt( 2,07);
			pstmt.setString( 3,"cse");
			pstmt.executeUpdate();

			pstmt.setString( 1, "Parth" );
			pstmt.setInt( 2,30);
			pstmt.setString( 3,"cse");
			pstmt.executeUpdate();
			System.out.println("Data Successfully Entered!");

		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
