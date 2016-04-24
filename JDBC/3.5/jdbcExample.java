// DELIMETER $$
// DROP PROCEDURE IF EXISTS `jdbc`.`getdata` $$
// CREATE PROCEDURE `jdbc`.`getdata` (IN in_branch varchar(255))
// BEGIN
// SELECT rollno,name,branch FROM student WHERE branch=in_branch;
// END $$
// DELIMETER ;
import java.sql.*;

public class jdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Harsh1408");
			CallableStatement callable = conn.prepareCall("{ call getdata(?)}");
			callable.setString(1,"cse");
			callable.executeUpdate();
			ResultSet rs = callable.getResultSet();
			while(rs.next()) {
			System.out.println(rs.getString(2)+"    "+rs.getInt(1)+"    "+rs.getString(3));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
