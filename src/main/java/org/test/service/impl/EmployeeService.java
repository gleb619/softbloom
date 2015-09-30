package org.test.service.impl;

import org.test.convertor.EmployeeListConvertor;
import org.test.dao.EmployeeDao;
import org.test.dao.LogDao;
import org.test.entity.Employee;
import org.test.entity.Log;
import org.test.entity.Search;
import org.test.service.MyService;
import org.test.util.Mockup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private Mockup mockup;
	private EmployeeListConvertor convertor = EmployeeListConvertor.BUILD();
	
	public Employee create(Employee data) {
		return employeeDao.create(data);
	}
	
	public Boolean mockup() {
		try {
			for (int index = 0; index < 100; index++) {
				Employee employee = new Employee();
				employee.setName(mockup.randomName());
				employee.setSalary(mockup.randomInteger(1000, 250000));
				employee.setJob(mockup.randomJob());
				employee.setWorking(mockup.randomBoolean());
				employee.setVacation(mockup.randomBoolean());
				employee.setFired(mockup.randomBoolean());
				employee.setGender(mockup.randomBoolean());
				try {
					create(employee);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Transactional
	public Employee update(Employee data) {
		return employeeDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Integer id) {
		return employeeDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> filter(Search search) {
		return convertor.convert(employeeDao.filter(search));
	}
	
	@Transactional(readOnly = true)
	public List<Employee> findAll(Boolean convert) {
		if(convert){
			return convertor.convert(employeeDao.findAll());
		}
		else {
			return employeeDao.findAll();
		}
	}
	
	@Transactional(readOnly = true)
	public Employee findById(Integer key) {
		return employeeDao.findById(key);
	}
	
}
