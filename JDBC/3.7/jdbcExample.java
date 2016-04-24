import java.sql.*;
import java.util.*;

public class jdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Database Name");
			String db = sc.nextLine();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db,"root","Harsh1408");
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("Driver name : " + dbmd.getDriverName());
			System.out.println("Driver Version : " + dbmd.getDriverVersion());
			System.out.println("Username : " + dbmd.getUserName());
			System.out.println("Database Product Name : " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version : " + dbmd.getDatabaseProductVersion());
			String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, "%", types);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
				System.out.println("Table name is: "+tableName);
				ResultSet resultSet = dbmd.getColumns(null, null,""+tableName, null);
				while (resultSet.next()) {
		              String name = resultSet.getString("COLUMN_NAME");
		              String type = resultSet.getString("TYPE_NAME");
		              int size = resultSet.getInt("COLUMN_SIZE");
              		  System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
          		}
            }
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}