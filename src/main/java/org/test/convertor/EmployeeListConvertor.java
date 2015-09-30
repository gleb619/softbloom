package org.test.convertor;

import java.util.List;

import org.test.entity.Employee;

public class EmployeeListConvertor {

	private static EmployeeListConvertor convertor;
	
	public EmployeeListConvertor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static EmployeeListConvertor BUILD() {
		if(convertor == null){
			convertor = new EmployeeListConvertor();
		}
		
		return convertor;
	}
	
	public List<Employee> convert(List<Employee> employees) {
		
		String fa = "fa-lg fa fa-";
		String check = fa + "check green";
		String times = fa + "times red";
		String man = fa + "male";
		String woman = fa + "female";
		
		
		for (Employee employee : employees) {
			employee.setWorkingclass(employee.getWorking() ? check : times);
			employee.setVacationclass(employee.getVacation() ? check : times);
			employee.setFiredclass(employee.getFired() ? check : times);
			employee.setGenderclass(employee.getGender() ? man : woman);
		}
		
		return employees;
	}
	
}
