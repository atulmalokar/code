package com.buffer.springboottutorial.service;

import java.util.List;

import com.buffer.springboottutorial.entity.Department;
import com.buffer.springboottutorial.exceptions.DepartmentNotFoundException;


public interface DepartmentService {
	
	public Department saveDepartment(Department department);

	public List<Department> getDepartments(Department department);

	public String deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

}
