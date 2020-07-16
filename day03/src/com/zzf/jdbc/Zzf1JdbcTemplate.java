package com.zzf.jdbc;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import a.User;
import dao.UserDao;
import dao.UserDaoImpl;
public class Zzf1JdbcTemplate {

	public static void main(String[] args) {
		//调用方法   alt+shift+m 抽取方法
		//findAllUser();
		//findOneUser();
		//addUser();
		//updateUser();
		//deleteUser();
		deleteUser1();
	}
	
	//根据姓名删除
	private static void deleteUser1() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update("delete from person where name=?","吸血鬼");
		System.out.println(update);
	}
	
	//根据id删除
			private static void deleteUser() {
				JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
				int update = jt.update("delete from person where id=?",5);
				System.out.println(update);
			}
	
	//修改方法
		private static void updateUser() {
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			int update = jt.update("update person set name=?,username=?,password=?,age=?,de=?,height=? where id=?","豹女","baonv",888,79,"十个豹女九个菜还有一个是代练",99,2);
			System.out.println(update);
		}
	
	//添加方法
	private static void addUser() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql="insert into person(name,username,password,age,de,height) values (?,?,?,?,?,?)";
		int update = jt.update(sql,"吸血鬼","xixuegui",666,235,"抽血泵后期贼强",178);
		System.out.println(update);
	}
	
	private static void findOneUser() {
			// 根据id查询单个英雄
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			String sql="select * from person where id=4";
			List<User> list=jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
			for(User user:list){
				System.out.println(user);
			}
	}
	
	private static void findAllUser() {
		// 查询所有英雄
				UserDao ud = new UserDaoImpl();
				List<User> list=ud.findAllUser();
				for(User user:list){
					System.out.println(user);
				}
		}
		
		

}
