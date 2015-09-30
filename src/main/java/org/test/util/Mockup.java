package org.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class Mockup {

	private final Faker faker = new Faker();
	private final List<String> jobs = new ArrayList<String>(){
		
		private static final long serialVersionUID = 9160641533296524339L;
		
	{
	
		add("HR Specialist");
		add("Bookkeeper & Receptionist");
		add("Sales and Service Specialist");
		add("Janitor");
		add("Big BOSS");
		
	}};
	
	public String randomJob() {
		return jobs.get(randomInteger(0, jobs.size() - 1));
	}
	
	public Boolean randomBoolean() {
		return radndomInteger() > 50;
	}
	
	public String randomName() {
		return faker.name().fullName();
	}
	
	public String randomString() {
		return randomString(randomInteger(5, 30));
	}
	
	public String randomString(Integer length) {
		return faker.lorem().fixedString(length);
	}
	
	public Integer radndomInteger() {
		return randomInteger(1, 100);
	}
	
	public Integer randomInteger(Integer min, Integer max) {
	    return new Random().nextInt((max - min) + 1) + min;
	}
	
}
