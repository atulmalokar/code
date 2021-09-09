package com.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void SaveCourseMaterial() {
		Course course = new Course();
		course.setTitle("dotnet");
		course.setCredit(6);
		CourseMaterial material= new CourseMaterial();
		material.setUrl("www.paithaniwale.com");
		material.setCourse(course);
		
		courseMaterialRepository.save(material);
	}

	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial>  courseMaterials=courseMaterialRepository.findAll();
		System.out.println("courseMaterials = "+courseMaterials);
	}
}
