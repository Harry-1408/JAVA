import java.sql.*;
import java.io.*;
public class ContinueAddData {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh","root","");
			PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do{
				System.out.println("Enter id : ");
				int id=Integer.parseInt(br.readLine());
				System.out.println("Enter First Name :");
				String name = br.readLine();
				System.out.println("Enter Age : ");
				int age = Integer.parseInt(br.readLine());
				stmt.setInt(1,id);
				stmt.setString(2,name);
				stmt.setInt(3,age);
				int i = stmt.executeUpdate();
				System.out.println(i + "records affected");
				System.out.println("Do You Want To Continue? Y/N");
				String s =br.readLine();

				if(s.startsWith("n || N")){
					break;
				}
			}while(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}