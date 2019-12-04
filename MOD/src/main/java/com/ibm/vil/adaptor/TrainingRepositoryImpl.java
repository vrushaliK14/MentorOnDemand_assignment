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

import com.ibm.vil.model.SearchTraining;

@Repository("TrainingRepository")
public class TrainingRepositoryImpl implements TrainingRepository {
	private static final Logger log = LoggerFactory.getLogger(TrainingRepositoryImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SearchTraining> getTrainingListByTechnology(String tech) {
		
		String query="select m.id, m.TECHNOLOGY,m.Mentor_name,m.start_date,m.end_date,m.batch_time,u.EXPERIENCE, u.name,t.TRAINING_FEE from MENTOR_CALENDAR m, user u ,TECHNOLOGIES t " + 
				"where  m.mentor_name=u.email and m.TECHNOLOGY=t.TECHNOLOGY and t.technology=m.technology and m.technology =? "; 
		
		List<SearchTraining> searchTraining= jdbcTemplate.query(query, new Object[]{tech}, new searchTrainingMapper());
		
		return searchTraining;
	}

	
	@Override
	public List<String> getTechnologyList() {
		
		String query="select technology from TECHNOLOGIES"; 
		
		List<String> techList= jdbcTemplate.queryForList(query, String.class);
		return techList;
	}

	
	@Override
	public List<SearchTraining> getTrainingListByTechTime(String batchTime, String technology) {
		
		String query="select m.id, m.TECHNOLOGY,m.Mentor_name,m.start_date,m.end_date,m.batch_time,u.EXPERIENCE,u.name,t.TRAINING_FEE from MENTOR_CALENDAR m, user u ,TECHNOLOGIES t " + 
				"where  m.mentor_name=u.email and m.TECHNOLOGY=t.TECHNOLOGY and t.technology=m.technology and m.batch_time = ? and m.technology =? "; 
		
		List<SearchTraining> searchTraining= jdbcTemplate.query(query, new Object[]{batchTime,technology}, new searchTrainingMapper());
		
		return searchTraining;
		
	}
	
	
	@Override
	public List<SearchTraining> getTrainingListByMentorTechTime(String batchTime, String technology,String mentorName) {
		
		String query="select  m.id, m.TECHNOLOGY,m.Mentor_name,m.start_date,m.end_date,m.batch_time,u.EXPERIENCE,u.name,t.TRAINING_FEE from MENTOR_CALENDAR m, user u ,TECHNOLOGIES t " + 
				"where  m.mentor_name=u.email and m.TECHNOLOGY=t.TECHNOLOGY and t.technology=m.technology and m.batch_time = ? and m.technology =? and u.name=? "; 
		
		List<SearchTraining> searchTraining= jdbcTemplate.query(query, new Object[]{batchTime,technology,mentorName}, new searchTrainingMapper());
		
		return searchTraining;
		
	}
	
	
	@Override
	public List<SearchTraining> getTrainingDEtailsForUser(String username) {
		
		String query="select *  from TRAINING_DETAILS where user_name=?"; 
		
		List<SearchTraining> searchTraining= jdbcTemplate.query(query, new Object[]{username}, new searchTrainingForUserMapper());
		
		return searchTraining;
		
	}
	
	
	public class searchTrainingMapper implements RowMapper<SearchTraining>{

			@Override
			public SearchTraining mapRow(ResultSet rs, int arg1) throws SQLException {
				SearchTraining searchTraining=new SearchTraining();
				searchTraining.setId(rs.getInt("id"));
				searchTraining.setBatchTime(rs.getString("batch_time"));
				searchTraining.setEndDate(rs.getDate("end_date"));
				searchTraining.setExperience(rs.getInt("EXPERIENCE"));
				searchTraining.setEmail(rs.getString("Mentor_name"));
				searchTraining.setStartDate(rs.getDate("start_date"));
				searchTraining.setTechnology(rs.getString("technology"));
				searchTraining.setMentorName(rs.getString("name"));
				searchTraining.setTrainingFee(rs.getInt("training_fee"));
				return searchTraining;
			}
			
	}
	

	public class searchTrainingForUserMapper implements RowMapper<SearchTraining>{

			@Override
			public SearchTraining mapRow(ResultSet rs, int arg1) throws SQLException {
				SearchTraining searchTraining=new SearchTraining();
				searchTraining.setId(rs.getInt("TRAINING_ID"));
				searchTraining.setBatchTime(rs.getString("batch_time"));
				searchTraining.setStartDate(rs.getDate("start_date"));
				searchTraining.setEndDate(rs.getDate("end_date"));
				searchTraining.setEmail(rs.getString("user_name"));
				searchTraining.setMentorName(rs.getString("mentor_name"));
				searchTraining.setTechnology(rs.getString("technology"));
				searchTraining.setPaymentStatus(rs.getInt("PAYMENT_STATUS"));
				searchTraining.setStatus(rs.getString("STATUS"));
				log.info("Searched Training:"+searchTraining.toString());
				return searchTraining;
			}
			
	}
	
	
	public boolean applyForTraining(SearchTraining training) {
		
		String query1 = "select max(TRAINING_ID)+1 from training_details";
		int nextId=jdbcTemplate.queryForObject(query1, Integer.class);
		
		
		String Query="insert into training_details (TRAINING_ID, TECHNOLOGY, USER_NAME, MENTOR_NAME, STATUS, BATCH_TIME, START_DATE, END_DATE, PAYMENT_STATUS, TRAINING_FEE)\r\n" + 
				"values(?,?,?,?,?,?,?,?,?,?)";
		int updated=jdbcTemplate.update(Query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, nextId);
				ps.setString(2, training.getTechnology());
				ps.setString(3, training.getUserName());
				ps.setString(4, training.getEmail());
				ps.setString(5, "Proposed");
				ps.setString(6, training.getBatchTime());
				ps.setDate(7, new java.sql.Date(training.getStartDate().getTime()));
				ps.setDate(8, new java.sql.Date(training.getEndDate().getTime()) );
				ps.setInt(9, 0);
				ps.setInt(10, training.getTrainingFee());
			}
		});
		
		log.info("rows updated in table :"+updated);
		if(updated>0) {
			return true;
		}else {
			return false;
		}
	}


	@Override
	public List<SearchTraining> getTrainingDEtailsForMentor(String mentorname) {
		String query="select *  from TRAINING_DETAILS where mentor_name=?"; 
		
		List<SearchTraining> searchTraining= jdbcTemplate.query(query, new Object[]{mentorname}, new searchTrainingForUserMapper());
		
		return searchTraining;
		
	}
	

	public boolean updateTrainingStatus(String status,int techId) {
			String query="UPDATE TRAINING_DETAILS SET STATUS=? WHERE TRAINING_ID=?";
			
			int updated=jdbcTemplate.update(query, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, status);
					ps.setInt(2, techId);
				}
			});
			
			log.info("rows updated in table :"+updated);
			if(updated>0) {
				return true;
			}else {
				return false;
			}
	}


	@Override
	public boolean deleteTechnology(String technology) {
		String query="delete from TECHNOLOGIES where technology=?";
		int count=jdbcTemplate.update(query, new Object[] {technology});
		if(count>0) {
			return true;
		}else
		return false;
	}


	@Override
	public boolean addTechnology(String technology, int fee) {

		String Query="insert into TECHNOLOGIES (TECHNOLOGY,TRAINING_FEE) " + 
				"values(?,?)";
		int updated=jdbcTemplate.update(Query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, technology);
				ps.setInt(2, fee);
			}
		});
		
		log.info("rows updated in table :"+updated);
		if(updated>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
