package com.zzf.jdbc;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import a.User;
import dao.UserDao;
import dao.UserDaoImpl;
public class Zzf1JdbcTemplate {

	public static void main(String[] args) {
		//���÷���   alt+shift+m ��ȡ����
		//findAllUser();
		//findOneUser();
		//addUser();
		//updateUser();
		//deleteUser();
		deleteUser1();
	}
	
	//��������ɾ��
	private static void deleteUser1() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update("delete from person where name=?","��Ѫ��");
		System.out.println(update);
	}
	
	//����idɾ��
			private static void deleteUser() {
				JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
				int update = jt.update("delete from person where id=?",5);
				System.out.println(update);
			}
	
	//�޸ķ���
		private static void updateUser() {
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			int update = jt.update("update person set name=?,username=?,password=?,age=?,de=?,height=? where id=?","��Ů","baonv",888,79,"ʮ����Ů�Ÿ��˻���һ���Ǵ���",99,2);
			System.out.println(update);
		}
	
	//��ӷ���
	private static void addUser() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql="insert into person(name,username,password,age,de,height) values (?,?,?,?,?,?)";
		int update = jt.update(sql,"��Ѫ��","xixuegui",666,235,"��Ѫ�ú�����ǿ",178);
		System.out.println(update);
	}
	
	private static void findOneUser() {
			// ����id��ѯ����Ӣ��
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			String sql="select * from person where id=4";
			List<User> list=jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
			for(User user:list){
				System.out.println(user);
			}
	}
	
	private static void findAllUser() {
		// ��ѯ����Ӣ��
				UserDao ud = new UserDaoImpl();
				List<User> list=ud.findAllUser();
				for(User user:list){
					System.out.println(user);
				}
		}
		
		

}
