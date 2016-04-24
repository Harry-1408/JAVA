import java.sql.*;
import java.util.*;

public class jdbcExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Harsh1408");
			Statement stmt = conn.createStatement();
			Scanner sc=new Scanner(System.in);
			int acc_no,balance;
			String name,phone_no,address,ans;
			while(true) {
				System.out.println("What Do you want ? \n 1.Insert 2.Update 3.Delete");
				int choice = Integer.parseInt(sc.nextLine());
					switch(choice) {
						case 1 : 
							System.out.println("You Selected To Insert the data");
							System.out.println("Enter Account Number");
							acc_no = Integer.parseInt(sc.nextLine());
							System.out.println("Enter Name");
							name = sc.nextLine();
							System.out.println("Enter Balance");
							balance = Integer.parseInt(sc.nextLine());
							System.out.println("Enter Phone Number");
							phone_no = sc.nextLine();
							System.out.println("Enter Address");
							address = sc.nextLine();
							String SQL = "INSERT INTO customer VALUES(" + acc_no + ",'" + name + "'," + balance + ",'" + phone_no + "','" + address + "')";
							stmt.executeUpdate(SQL);
							System.out.println("Data Successfully Entered!");
							break;
						case 2:
							System.out.println("You Selected To Update the data");
							System.out.println("Enter Account Number In Which You Want To Update Balance");
							acc_no = Integer.parseInt(sc.nextLine());
							System.out.println("Enter Balance");
							balance = Integer.parseInt(sc.nextLine());
							SQL = "UPDATE customer SET balance = " + balance +  " where acc_no = " + acc_no;
							stmt.executeUpdate(SQL);
							System.out.println("Data Successfully Updated!");
							break;
						case 3:
							System.out.println("You Selected To Delete The Data!");
							System.out.println("Enter The Account Number To Delete that account!");
							acc_no = Integer.parseInt(sc.nextLine());
							SQL = "DELETE from customer where acc_no = " + acc_no ;
							stmt.executeUpdate(SQL);
							System.out.println("Data Successfully Deleted!");
							break;
						default : 
							System.out.println("Wrong Choice!");
							break;
					}
					System.out.println("Do you want to Continue!(Y/N)");
					ans = sc.nextLine();
					if(ans.equals("N")) {
						break;
					}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}