package com.motivation.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login 
{
	String userName;
	String userPwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public boolean checkLogin()
	{
		boolean ch=false;
		try
		{
			MyConnection ob=new MyConnection();
			Connection cn=ob.doConnect();
			String qry="select *from login where username=? and passwd=?";
			PreparedStatement ps=cn.prepareStatement(qry);
			ps.setString(1, userName);
			ps.setString(2,userPwd);
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
