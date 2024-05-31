package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getby {
	
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
//		4.close
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter database name");
			
			String Url = "jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName(Driver);
			
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			
			System.out.println("Enter table name");
			
			String sql = "select * from "+sc.next()+" where id = ?";
			
			pmst = conn.prepareStatement(sql);
			
			System.out.println("Enter id");
			
			pmst.setString(1, sc.next());
			
			ResultSet rs = pmst.executeQuery();
			
			while (rs.next()) {
				System.out.println("id: "+rs.getInt("id"));
				System.out.println("name: "+rs.getString("name"));
				System.out.println("email: "+rs.getString("email"));
				
			}
			
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}