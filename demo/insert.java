package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {
	
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
			String sql = "insert into "+sc.next()+"(id,name,email)values(?,?,?)";
			pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter id");
			
			pmst.setInt(1, sc.nextInt());
			
			System.out.println("enter name");
			
			pmst.setString(2, sc.next());
			
			System.out.println("Enter email");
			
			pmst.setString(3, sc.next());
			
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("table created successfully");
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