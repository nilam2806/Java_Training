package com.training.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCOperations {
	private Connection con;
	private String username;
	private String password;
	private String query;
	private Statement stmt;

	public JDBCOperations() {
		System.out.println("Default constructor of JDBCOperations is called");
		con = null;
		username = "";
		password = "";
		query = "";

	}

	public static Connection mysqlConnection(String username, String password) throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/org?autoReconnect=true&useSSL=false", username,
				password);
		return con;
	}

	public JDBCOperations(String username, String password) throws SQLException {
		this.username = username;
		this.password = password;
		this.con = JDBCOperations.mysqlConnection(username, password);
		System.out.println(this.con);
		stmt = con.createStatement();
		query = "";
	}

	public void CreateDatabase(String name) throws SQLException {
		stmt = con.createStatement();
		// send sql command
		String query = "create database " + name;
		stmt.executeUpdate(query);
		System.out.println("Database Created");
	}

	public void CreateTable(String query) throws SQLException {
		stmt = con.createStatement();
		// send sql command

		System.out.println(stmt.executeUpdate(query));
		System.out.println("Table is Created");
	}

	public void insertData() throws SQLException, NumberFormatException, IOException {
		// stmt=conn.createStatement();
//		stmt.execute("insert into jdbc values(101, 'nilam', 40000)");
//		stmt.execute("insert into jdbc values(102, 'yash', 20000)");
//		stmt.execute("insert into jdbc values(103, 'ashu', 50000)");
//		stmt.execute("insert into jdbc values(104, 'nisha', 30000)");

//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Reading data from user
//
//		 System.out.println("Enter Employee ID:");
//		 int id = Integer.parseInt(br.readLine());
//
//		 System.out.println("Enter Employee Name:");
//		 String name = br.readLine();
//
//		 System.out.println("Enter Employee Salary:");
//		 double salary  = Double.parseDouble(br.readLine());
//
//		 stmt.executeUpdate("insert into jdbc values("+id+ ", '"+name+"',"+salary+")");
//
//		 System.out.println(name + " record inserted");

		PreparedStatement pst = con.prepareStatement("insert into jdbc values(?,?,?)");

		// taking values from keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Employee ID:");
		int id = Integer.parseInt(br.readLine());

		System.out.println("Enter Employee Name:");
		String name = br.readLine();

		System.out.println("Enter Employee Salary:");
		double salary = Double.parseDouble(br.readLine());

//The values are stored in local varables, id, name and salary

		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setDouble(3, salary);

		pst.executeUpdate();

		System.out.println(name + " Record is inserted");

	}

	public void showRecords() throws SQLException {
		ResultSet rs = stmt.executeQuery("select *from jdbc");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

	}
	
	public void deleteRecord(int id) throws SQLException {
		Statement stmt = con.createStatement();

		
		int x = stmt.executeUpdate("delete Employee where empid >="+ id);

	      System.out.println(id + " record is deleted");
	      System.out.println(x + " records are deleted");
	}

	public void closemyConnection() throws SQLException {
		if (this.con != null) {
			this.con.close();
			System.out.println("Connection is closing..");
		} else {
			System.out.println("Cant able to close connection");
		}
	}
}
