package com.buffer.springboottutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buffer.springboottutorial.entity.Department;
import com.buffer.springboottutorial.exceptions.DepartmentNotFoundException;
import com.buffer.springboottutorial.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	private final Logger Logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody	Department department) {
		Logger.info("Inside save departmentController");
		return service.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartments(Department department) {
		return service.getDepartments(department);
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException
	{
		return service.fetchDepartmentById(departmentId);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		return service.deleteDepartmentById(departmentId);
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		return service.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/departments/name/{name}")
		public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
			return service.fetchDepartmentByName(departmentName);
		}
	
}
