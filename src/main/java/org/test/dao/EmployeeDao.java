package org.test.dao;

import org.test.entity.Employee;
import org.test.entity.Search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@PersistenceContext
	private EntityManager em;
	private final String selectClause = "SELECT emp0 FROM Employee emp0";
	private final String filterClause = "SELECT emp0 FROM Employee emp0 WHERE lower(emp0.name) like lower(:filter)";

	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		Query query = em.createQuery(selectClause);
		List<Employee> result = new ArrayList<Employee>();
		try {
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> filter(Search search) {
		Query query = em.createQuery(filterClause);
		List<Employee> result = new ArrayList<Employee>();
		try {
			result = query
					.setParameter("filter", "%" + search.getFilter() + "%")
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Employee findById(Integer id) {
		return em.find(Employee.class, id);
	}

	public Employee create(Employee employee) {
		em.persist(employee);
		return employee;
	}
	
	public Employee update(Employee employee) {
		return em.merge(employee);
	}

	public Boolean delete(Integer id) {
		try {
			em.remove(em.getReference(Employee.class, id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
