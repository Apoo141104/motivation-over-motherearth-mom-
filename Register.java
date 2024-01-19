package com.motivation.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register {
	String userName;
	String userPwd1;
	String userPwd2;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd1() {
		return userPwd1;
	}
	public void setUserPwd1(String userPwd1) {
		this.userPwd1 = userPwd1;
	}
	public String getUserPwd2() {
		return userPwd2;
	}
	public void setUserPwd2(String userPwd2) {
		this.userPwd2 = userPwd2;
	}
	public boolean register()
	{
		boolean ch=false;
		
		try
		{
			MyConnection ob=new MyConnection();
			Connection cn=ob.doConnect();
			String qry="insert into login values(?,?)";
			PreparedStatement ps=cn.prepareStatement(qry);
			ps.setString(1, userName);
			ps.setString(2,userPwd1);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{ch=true;}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ch;
	}
}
