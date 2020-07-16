package dao;
import com.zzf.jdbc.JDBCUtils;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.util.JdbcUtils;
import a.User;

public class UserDaoImpl implements UserDao{
	JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public List<User> findAllUser(){
		String sql = "select * from person;";
		List<User> list = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}
}
