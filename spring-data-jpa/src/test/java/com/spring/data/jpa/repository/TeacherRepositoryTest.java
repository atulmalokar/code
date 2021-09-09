package com.spring.data.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course course= new Course();
		course.setTitle("Java");
		course.setCredit(6);
		Course course2= new Course();
		course2.setTitle("Android");
		course2.setCredit(4);
		List<Course> courses= new ArrayList<Course>();
		courses.add(course);
		courses.add(course2);
		Teacher teacher= new Teacher();
		teacher.setFirstName("Sathish");
		teacher.setLastName("kumar");
		//teacher.setCourses(courses);
		
		teacherRepository.save(teacher);
	}

}
