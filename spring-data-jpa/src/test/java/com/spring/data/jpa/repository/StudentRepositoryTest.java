package com.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
//	public void saveStudent() {
//	
//		Student student= new Student();
//		student.setEmailId("atulmalokar14@gmail.com");
//		student.setFirstName("Atul");
//		student.setLastName("Malokar");
//		student.setGuardianName("Sathish");
//		student.setGuardianEmail("sathish@cdac.in");
//		student.setGuardianMobile("9876543210");
//	studentRepository.save(student);
//	}

//	@Test
//	public void saveStudentWithGuardianDetails() {
//		
//		Guardian guardian= new Guardian();
//		guardian.setName("Abhijeet");
//		guardian.setEmail("abhijit@gmail.com");
//		guardian.setMobile("987654321");
//		
//		Student student= new Student();
//		student.setFirstName("Chaitanya");
//		student.setEmailId("chaitanya@gmail.com");
//		student.setLastName("Kshatriya");
//		student.setGuardian(guardian);
//		
//		studentRepository.save(student);
//	}
//	@Test
//	public void printAllStudent() {
//		List<Student>  studentList=studentRepository.findAll();
//		System.out.println("student List : "+studentList);
//	}
	
//	@Test
//	public void printStudentByFirstName() {
//		List<Student> students=studentRepository.findByFirstName("chaitanya");
//		System.out.println("students = "+students);
//	}
//	@Test
//	public void printStudentByFirstNameContaining() {
//		List<Student> students=studentRepository.findByFirstNameContaining("at");
//		System.out.println("students = "+students);
//	}
	
	@Test
	public void printStudentByGuardianName() {
		List<Student> students=studentRepository.findByGuardianName("abhijeet");
		System.out.println("students = "+students);
	}
	
	@Test
	public void printgetStudentByEmailAddress() {
		Student student= studentRepository.getStudentByEmailAddress("chaitanya@gmail.com");
		
		System.out.println("Student by email is " + student);
		
	}
	@Test
	public void printgetStudentFisrtNameByEmailAddress() {
		String firstName= studentRepository.getStudentFirstNameByEmailAddress("chaitanya@gmail.com");
		
		System.out.println("Student by email is " + firstName);
		
	}
	
	@Test
	public void printgetStudentByEmailAddressNative() {
		Student student= studentRepository.getStudentByEmailAddressNative("chaitanya@gmail.com");
		
		System.out.println("Student by email is " + student);
		
	}
}
