package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");
		/* Spring JDBC => Jdbc Template */

		// 1st way : When we use .xml file
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("com/springjdbc/config.xml");

		// 2nd way : Without use .xml file using javaConfig class
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * // This Is Not Proper Way To access or manipulate data from database
		 * JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		 * // Insert Query String query =
		 * "insert into student(id,name,city) values(?,?,?)"; // Fire The Query int
		 * result = template.update(query, 115, "Vasudev Kittur", "Mangao");
		 * System.out.println("Number Of Record Inserted : " + result);
		 */
		
		/*
		 * Student student = new Student(); student.setId(115);
		 * student.setName("Vasudev Kittur"); student.setCity("Mumbai"); int result =
		 * studentDao.insert(student); System.out.println("Student Added  : " + result);
		 */

		/*
		 * Student student = new Student(); student.setId(115);
		 * student.setName("Anurodh Kittur"); student.setCity("Mangao"); int result1 =
		 * studentDao.update(student); System.out.println("Student Update  : " +
		 * result1);
		 */

		/*
		 * Student student = new Student(); int result2 = studentDao.delete(115);
		 * System.out.println("Student Delete Permanantly  : " + result2);
		 */

		/*
		 * Student student = studentDao.getStudent(112); System.out.println(student);
		 */

		List<Student> allStudent = studentDao.getAllStudent();
		for (Student s : allStudent) {
			System.out.println(s);
		}
	}
}
