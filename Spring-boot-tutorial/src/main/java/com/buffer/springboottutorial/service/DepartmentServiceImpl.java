package com.buffer.springboottutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buffer.springboottutorial.entity.Department;
import com.buffer.springboottutorial.exceptions.DepartmentNotFoundException;
import com.buffer.springboottutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository repository;
	
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public List<Department> getDepartments(Department department) {
		
		return repository.findAll();
	}

	@Override
	public String deleteDepartmentById(Long departmentId) {
		repository.deleteById(departmentId);
		return "Department Deleted Successfully";
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department departmentDB= repository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			departmentDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			departmentDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			departmentDB.setDepartmentCode(department.getDepartmentCode());
		}
			
			
		return repository.save(departmentDB);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		
		return repository.findByDepartmentName(departmentName);
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		
		Optional<Department> department= repository.findById(departmentId);
		
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Available");
		}
		
		return department.get();
	}

}
