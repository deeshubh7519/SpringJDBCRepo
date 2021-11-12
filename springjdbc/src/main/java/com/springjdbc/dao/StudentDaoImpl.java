package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		// Insert Query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int update(Student student) {
		// Update Query
		String query1 = "update student set name=?, city=? where id=?";
		int result1 = this.jdbcTemplate.update(query1, student.getName(), student.getCity(), student.getId());
		return result1;
	}

	public int delete(int sid) {
		// Delete Query
		String query2 = "delete from student where id=?";
		int result2 = this.jdbcTemplate.update(query2, sid);
		return result2;
	}

	public Student getStudent(int id) {
		// Select Single Student data
		String query3 = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		/*
		 * // We Can Use anonymous class // @SuppressWarnings("unchecked")
		 * 
		 * Student student = this.jdbcTemplate.queryForObject(query3, new RowMapper() {
		 * public Object mapRow(ResultSet rs, int rowNum) throws SQLException { Student
		 * student = new Student(); student.setId(rs.getInt(1));
		 * student.setName(rs.getString(2)); student.setCity(rs.getString(3)); return
		 * student; } }, id);
		 */
		 
		Student student = this.jdbcTemplate.queryForObject(query3, rowMapper, id);
		return student;
	}

	public List<Student> getAllStudent() {
		// Selecting Multiple Student
		String query4 = "select * from student ";
		List<Student> students = this.jdbcTemplate.query(query4, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
