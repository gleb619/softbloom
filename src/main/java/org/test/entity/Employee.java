package org.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 5435136387938459409L;

	private Integer id;

	private String name;
	private Integer salary;
	private String job;
	private Boolean working;
	private Boolean vacation;
	private Boolean fired;
	private Boolean gender;

	public Employee() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Boolean getWorking() {
		return working;
	}

	public void setWorking(Boolean working) {
		this.working = working;
	}

	public Boolean getVacation() {
		return vacation;
	}

	public void setVacation(Boolean vacation) {
		this.vacation = vacation;
	}

	public Boolean getFired() {
		return fired;
	}

	public void setFired(Boolean fired) {
		this.fired = fired;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fired == null) ? 0 : fired.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result
				+ ((vacation == null) ? 0 : vacation.hashCode());
		result = prime * result + ((working == null) ? 0 : working.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (fired == null) {
			if (other.fired != null)
				return false;
		} else if (!fired.equals(other.fired))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (vacation == null) {
			if (other.vacation != null)
				return false;
		} else if (!vacation.equals(other.vacation))
			return false;
		if (working == null) {
			if (other.working != null)
				return false;
		} else if (!working.equals(other.working))
			return false;
		return true;
	}

	/* ================== 30 сент. 2015 г. ================== */

	private String salarytype;
	private String workingclass;
	private String vacationclass;
	private String firedclass;
	private String genderclass;

	@Transient
	public String getSalarytype() {
		return salarytype;
	}

	public void setSalarytype(String salarytype) {
		this.salarytype = salarytype;
	}

	@Transient
	public String getWorkingclass() {
		return workingclass;
	}

	public void setWorkingclass(String workingclass) {
		this.workingclass = workingclass;
	}

	@Transient
	public String getVacationclass() {
		return vacationclass;
	}

	public void setVacationclass(String vacationclass) {
		this.vacationclass = vacationclass;
	}

	@Transient
	public String getFiredclass() {
		return firedclass;
	}

	public void setFiredclass(String firedclass) {
		this.firedclass = firedclass;
	}

	@Transient
	public String getGenderclass() {
		return genderclass;
	}

	public void setGenderclass(String genderclass) {
		this.genderclass = genderclass;
	}

}
