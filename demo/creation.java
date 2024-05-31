package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class creation {
	
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
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(Url, Username, Password);
			System.out.println("Enter database name");
			String sql = "create database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("database created successfully");
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