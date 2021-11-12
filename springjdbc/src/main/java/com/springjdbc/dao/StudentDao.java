package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entities.Student;

//This class Is Use For Loose Coupling and it is needed implemented class which is (StudentDaoImpl)
public interface StudentDao {

	public int insert(Student student);

	public int update(Student student);

	public int delete(int id);

	public Student getStudent(int id);

	public List<Student> getAllStudent();
}
