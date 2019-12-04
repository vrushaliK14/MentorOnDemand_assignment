package com.ibm.vil.adaptor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ibm.vil.data.model.User;
import com.ibm.vil.model.UserProfile;


@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public User findUserByName(String name) {
		User user= jdbcTemplate.queryForObject("select * from user where email=?", new Object[]{name}, new UsreDataMapper());
		return user;
	}
	

	@Override
	public List<String> getMentorList() {
		
		String query="select name from user"; 
		
		List<String> mentorList= jdbcTemplate.queryForList(query, String.class);
		return mentorList;
	}

	
	public boolean isUserPasswordValid(String username ,String password) {
		int count= jdbcTemplate.queryForObject("select count(*) from user where email=? and password=? ", new Object[]{username,password}, Integer.class);
		if(count>0) {
			return true;
		}else 
			return false;
	}
	
	public String getUserRole (String username) {
		String role= jdbcTemplate.queryForObject("select role from user where email=?", new Object[]{username}, String.class);
		return role;
	}
	
	public class UsreDataMapper implements RowMapper<User> {
	
		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("ID"));
			user.setUserName(rs.getString("NAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setAddress(rs.getString("ADDRESS"));
			user.setUserRole(rs.getString("ROLE"));
			user.setEmail(rs.getString("EMAIL"));
			user.setPhoneNo(rs.getString("PHONE_NO"));
			user.setTime_selectedItems(rs.getString("BATCH_TIMES"));
			user.setTech_selectedItems(rs.getString("TECHNOLOGIES"));
			user.setExperience(rs.getInt("EXPERIENCE"));
			user.setAverage_rating(rs.getInt("AVERAGE_RATING"));
			user.setNo_of_trainings_dlvr(rs.getInt("NO_OF_TRAININGS_DLVR"));
			return user;
		}
	}
	
	public void createUser(UserProfile userProfile) {
		String sql="INSERT INTO USER (ID,NAME,ROLE,EMAIL,PASSWORD,PHONE_NO,ADDRESS,BATCH_TIMES,TECHNOLOGIES,EXPERIENCE,AVERAGE_RATING,NO_OF_TRAININGS_DLVR)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String getMaxID="select max(id)+1 from user";
		int maxId=jdbcTemplate.queryForObject(getMaxID, Integer.class);
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				String technologies=null;
				String timebatch=null;
				for(String technology:userProfile.getTech_selectedItems()) {
					technologies= technology +","+technologies ;
				}
				
				for(String time:userProfile.getTime_selectedItems()) {
					timebatch= time + ","+timebatch ;
				}
				ps.setInt(1, maxId);
				ps.setString(2, userProfile.getUserName());
				ps.setString(3, userProfile.getUserRole());
				ps.setString(4, userProfile.getEmail());
				ps.setString(5, userProfile.getPassword());
				ps.setString(6, userProfile.getPhoneNo());
				ps.setString(7, userProfile.getAddress());
				ps.setString(8, timebatch);
				ps.setString(9, technologies);
				ps.setInt(10, userProfile.getExperience());
				ps.setInt(11, userProfile.getAverage_rating());
				ps.setInt(12, userProfile.getNoOfTrainingsDlvr());
				}
		});
		log.debug("updated user");

	}
	
	public List<User> findAllUsers(){
			String query="select * from user";
			List<User> userList=jdbcTemplate.query(query,new UsreDataMapper());
			return userList;
	}
	
}
