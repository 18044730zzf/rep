package com.zzf.jdbc;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;

public class Zzf1Druid {
	public static void main(String[] args) throws Exception{
		Properties pro = new Properties();
		InputStream resourceAsStream = Zzf1Druid.class.getClassLoader().getResourceAsStream("resources/jdbc.properties2");
		pro.load(resourceAsStream);
		String property = pro.getProperty("name");
		String password = pro.getProperty("password");
		System.out.println(password);
		System.out.println(property);
		//���ݿ����ӳض���
		DataSource datasource = DruidDataSourceFactory.createDataSource(pro);
		// ���ݿ�����
		System.out.println(datasource.getConnection());
		//��ȡ����
		java.sql.Connection connection = datasource.getConnection();
		System.out.println("��ȡ������"+connection);
		//ִ��sql����
		Statement createStatement =connection.createStatement();
		//����sql
		String sql = "select * from person;";
		//ִ�в�ѯ
		ResultSet rs= createStatement.executeQuery(sql);
		//�������
		while(rs.next()){
			String name=rs.getString("name");
			System.out.println(name);
		}
		//�黹����
		connection.close();

	}
}