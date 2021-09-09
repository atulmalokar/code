package com.spring.data.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Course {

	//to create primary key for courseId
	@Id
	//Generating sequence which creates a course_sequense table separately
	@SequenceGenerator(
			name = "course_sequence" ,
			sequenceName="course_sequence",
			allocationSize = 1
			)
	//primary key auto increment
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence"
			)
	private Long courseId;
	private String title;
	private Integer credit;
	//making mapping bi directional
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial courseMaterial;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherId"
			)
	private Teacher teacher;
	
	public Course() {
	}
	public Course(Long courseId, String title, Integer credit) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.credit = credit;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "CourseMaterial [courseId=" + courseId + ", title=" + title + ", credit=" + credit + "]";
	}
	
	@ManyToMany(
			cascade = CascadeType.ALL
			)
	@JoinTable(
			name = "student_course_map",
			joinColumns = @JoinColumn(
					name="course_id",
					referencedColumnName = "courseId"
					),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentId"
					)
			)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if (students==null) students = new ArrayList<Student>();
		students.add(student);
	}
}
