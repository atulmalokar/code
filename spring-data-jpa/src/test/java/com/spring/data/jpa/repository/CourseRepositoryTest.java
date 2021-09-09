package com.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.Student;
import com.spring.data.jpa.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> courses= courseRepository.findAll();
		System.out.println("courses= " + courses);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher= new Teacher();
		teacher.setFirstName("Pranaw");
		teacher.setLastName("singh");
		Course course= new Course();
		course.setTitle("python");
		course.setCredit(10);
		course.setTeacher(teacher);
		courseRepository.save(course);
	}

	@Test
	public void findAllPagination() {
		//Pageable firstPageWithThreeRecords=PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords=PageRequest.of(1, 2);
		List<Course> courses=courseRepository.findAll(secondPageWithTwoRecords).getContent();
		
		long totalElements=courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		long totalPages=courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
		
		System.out.println("Total Pages is "+totalPages);
		System.out.println("Total element is "+totalElements);
		System.out.println("Courses = "+courses);
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle=
				PageRequest.of(0, 2, Sort.by("title"));
		//Pageable sortByCreditDesc=PageRequest.of(0, 2, Sort.by("credit").descending());
	//	Pageable sortByTitleAndCreditDesc=PageRequest.of(0, 2,Sort.by("title").descending().and(Sort.by("credit")));
		List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
		System.out.println("Courses = "+courses);
	}
	
	@Test
	public void findByTitleContaining() {
		Pageable firstPageTenRecords=PageRequest.of(0, 10);
		List<Course> courses=courseRepository.findByTitleContaining("J", firstPageTenRecords).getContent();
		System.out.println("courses= "+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher= new Teacher();
		teacher.setFirstName("Anil");
		teacher.setLastName("singh");
		
		Student student= new Student();
		student.setFirstName("Ajinkya");
		student.setLastName("sharma");
		student.setEmailId("ajinkya@gmail.com");
		
		Course course= new Course();
		course.setTitle("golang");
		course.setCredit(7);
		course.setTeacher(teacher);
		course.addStudents(student);
		
		courseRepository.save(course);
		
	}
}
