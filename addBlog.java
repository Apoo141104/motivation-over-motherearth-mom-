package com.motivation.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class addBlog {
	String name;
	String title;
	String link;
	String caption;
	String blog;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public boolean AddBlogs()
	{
		boolean ch=false;
		try
		{
			MyConnection ob=new MyConnection();
			Connection cn=ob.doConnect();
			String qry="insert into blogs values(?,?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(qry);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, blog);
			ps.setString(4, link);
			ps.setString(5, caption);
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
