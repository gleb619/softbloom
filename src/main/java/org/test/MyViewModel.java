package org.test;

import org.test.entity.Employee;
import org.test.entity.Log;
import org.test.entity.Search;
import org.test.service.MyService;
import org.test.service.impl.EmployeeService;
import org.test.util.Mockup;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

	@WireVariable
	private EmployeeService employeeService;
	private Search search;
	private List<Employee> employesList = new ArrayList<Employee>();
	private Employee selectedEmployee;
	private Boolean startLoad = false;

	@Init
	@NotifyChange("startLoad")
	public void init() {
		startLoad = true;
	}

	@Command
	@NotifyChange({"employesList", "startLoad"})
	public void onLoad() {
		loadEmployee(false);
		
		if(employesList.size() == 0){
			employeeService.mockup();
			loadEmployee(true);
		}
		startLoad = false;
	}
	
	public void loadEmployee(Boolean convert) {
		try {
			employesList = employeeService.findAll(convert);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Command
	public void onSelect() {
		System.out.println("MyViewModel.onEdit()#selectedEmployee: " + selectedEmployee);
	}
	
	@Command
	@NotifyChange("employesList")
	public void onFilter() {
		System.out.println("MyViewModel.onFilter()");
		employeeService.filter(search);
	}
	
	@Command
	public void onEdit(@BindingParam("item") Employee employee) {
		System.out.println("MyViewModel.onEdit()#employee: " + employee);
	}

	/* ================== 30 сент. 2015 г. ================== */
	
	public Search getSearch() {
		return search;
	}
	
	public void setSearch(Search search) {
		this.search = search;
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public List<Employee> getEmployesList() {
		return employesList;
	}

	public void setEmployesList(List<Employee> employesList) {
		this.employesList = employesList;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public Boolean getStartLoad() {
		return startLoad;
	}

	public void setStartLoad(Boolean startLoad) {
		this.startLoad = startLoad;
	}

}
