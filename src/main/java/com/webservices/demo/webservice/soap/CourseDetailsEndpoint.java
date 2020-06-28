package com.webservices.demo.webservice.soap;


import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jaxb.xml.courses.CourseDetails;
import com.jaxb.xml.courses.GetAllCoursesDetailsRequest;
import com.jaxb.xml.courses.GetAllCoursesDetailsResponse;
import com.jaxb.xml.courses.GetCourseDetailsRequest;
import com.jaxb.xml.courses.GetCourseDetailsResponse;
import com.webservices.demo.webservice.soap.bean.Course;
import com.webservices.demo.webservice.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	private CourseDetailsService service =new CourseDetailsService() ;
	
	@PayloadRoot(namespace = "http://courseService.com",
				localPart = "GetCourseDetailsRequest")
	
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) 
	{
		Course course = service.findByID(request.getId());
		
		return mapCourseDetails(course);
	}
	
	
	
	@PayloadRoot(namespace = "http://courseService.com",
			localPart = "GetAllCoursesDetailsRequest")

	@ResponsePayload
	public GetAllCoursesDetailsResponse
	processAllCoursesDetailsRequest(@RequestPayload GetAllCoursesDetailsRequest request) 
	{
		List<Course> courses = service.findAll();
		
		
		return mapAllCourseDetails(courses);
	}
	
	private GetAllCoursesDetailsResponse mapAllCourseDetails(List<Course> courses) {
		
		GetAllCoursesDetailsResponse response =new GetAllCoursesDetailsResponse();
		for(Course course :courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		

		
		return response;
	}
		
		private GetCourseDetailsResponse mapCourseDetails(Course course) {
			
			GetCourseDetailsResponse response =new GetCourseDetailsResponse();

			response.setCourseDetails(mapCourse(course));
			
			return response;
		}
		


		private CourseDetails mapCourse(Course course) {
			CourseDetails courseDetails =new CourseDetails();
			
			courseDetails.setId(course.getId());
			
			courseDetails.setName(course.getName());
			
			courseDetails.setDescription(course.getDescription());
			
			return courseDetails;
		}
	}
