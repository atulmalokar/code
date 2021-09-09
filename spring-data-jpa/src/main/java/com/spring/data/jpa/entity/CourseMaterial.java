package com.spring.data.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.ToString;

@Entity
@ToString(exclude = "course")
public class CourseMaterial {

	//create primary key of courseMaterialId
	@Id
	//creating sequence generator schema with name course_material_sequence
	@SequenceGenerator(
			name = "course_material_sequence",
			sequenceName = "course_material_sequence",
			allocationSize = 1
			)
	//Auto increament the sequence by 1
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_material_sequence"
			)
	private Long courseMaterialId;
	private String url;
	
	//define one to one mapping
	
	//unidirectional mapping as course doesn't have any reference of course material
	//making it bidirectional by adding reference of courseMaterial to course class
	@OneToOne(
			//to execute one to one mapping first course must be added to the database 
			//here course is not added before hence we have to cascade it 
		
			cascade = CascadeType.ALL,
			//fetching data lazily in console
			fetch = FetchType.LAZY,
			//optional just to clear that without related course material available in the database 
			//user can not enroll for the course
			optional = false
			)
	//define foreign key column courseId
	@JoinColumn(
			name = "course_id",
			referencedColumnName ="courseId" 
			)
	private Course course;

	public CourseMaterial() {
	}

	public CourseMaterial(Long courseMaterialId, String url, Course course) {
		super();
		this.courseMaterialId = courseMaterialId;
		this.url = url;
		this.course = course;
	}

	public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + "]";
	}
	
}
