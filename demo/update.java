package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
	
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Username = "root";
	public static final String Password = "root";
	public static final String Url = "jdbc:mysql://localhost:3306/";
	public static Connection conn;
	public static PreparedStatement pmst;

	public static void main(String[] args) {
		
//		1.Driver
//		2.create connection
//		3.statement creation
//		4.statement execution
//		5.close
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter database name");
			
			String Url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter table name");
			String sql = "update "+sc.next()+" set name = ?, email =? where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter name");
			
			pmst.setString(1, sc.next());
			
			System.out.println("enter email");
			
			pmst.setString(2, sc.next());
			
			System.out.println("Enter id");
			
     		pmst.setInt(3, sc.nextInt());
			
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("database updated successfully");
			}
			else {
				System.out.println("Error");
			}
			
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}