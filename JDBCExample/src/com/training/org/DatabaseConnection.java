package com.training.org;

import java.sql.SQLException;

public class DatabaseConnection {
	public static void main(String[] args) throws SQLException {
		try {
		JDBCOperations jb=new JDBCOperations("root","root");
		//jb.CreateDatabase("newdatabase");
		
		//jb.CreateTable("create table ODBC(empid int, name varchar(30), salary int)");
		//jb.insertData();
		//jb.showRecords();
		jb.deleteRecord(101);
		jb.closemyConnection();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
