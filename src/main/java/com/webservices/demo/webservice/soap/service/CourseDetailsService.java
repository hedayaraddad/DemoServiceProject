package com.webservices.demo.webservice.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import com.webservices.demo.webservice.soap.bean.Course;
@Component
public class CourseDetailsService {
	private static List<Course> courses =new ArrayList<Course>();
	
	static {
		Course course1=new Course(1,"Spring framework", "10 steps to learn");
		courses.add(course1);
		
		Course course2=new Course(2,"Spring MVS framework", "10 steps to learn");
		courses.add(course2);
		
		Course course3=new Course(3,"Spring boot ", "10 steps to learn");
		courses.add(course3);
		
		Course course4=new Course(4,"Spring cloud ", "10 steps to learn");
		courses.add(course4);
	}
	
	public Course findByID(int id ){
		for(Course course : courses) {
			if(course.getId() == id ) {
				System.out.println(course.toString());
				return course;
			}
		}
		return null ;
	}
	
	public List<Course> findAll(){
		return courses;
	}
	
	public int deleteById(int id) {
		Iterator<Course> iterator =courses.iterator();
		while(iterator.hasNext()) {
			Course course =iterator.next();
			if(course.getId() == id) {
				courses.remove(course);
				return 1 ; 
			}
		}
		return 0 ;
	}
}
