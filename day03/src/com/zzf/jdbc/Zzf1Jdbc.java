package com.zzf.jdbc;

import java.sql.*;

public class Zzf1Jdbc {
	public static void main(String[] args) throws Exception  {
			// 1. �������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// 2.ͨ��DriverManager��ȡ���ݿ�����
			String url = "jdbc:mysql://127.0.0.1:3306/swing";
			String username = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url,username, password);
			// 3.ͨ��Connection�����ȡStatement����
			Statement createStatement=connection.createStatement();
			// 4.ʹ��Statementִ��SQL���
			String sql = "select * from person;";
			//
			ResultSet rs=createStatement.executeQuery(sql);
			//
			while(rs.next()){
				String name=rs.getString("name");
				System.out.println(name);
			}
			// 6.�ر����ӣ��ͷ���Դ
			createStatement.close();
			connection.close();
		}
}