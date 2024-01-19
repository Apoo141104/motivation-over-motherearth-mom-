package com.motivation.entity;

import java.sql.*;

import oracle.jdbc.OracleDriver;
public class MyConnection 
{
	Connection cn=null;
	public Connection doConnect()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="studentdb";
			String pwd="tiger";
			cn=DriverManager.getConnection(url,user,pwd);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cn;
	}
}
