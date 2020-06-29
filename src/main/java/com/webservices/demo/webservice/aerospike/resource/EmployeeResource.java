package com.webservices.demo.webservice.aerospike.resource;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.webservices.demo.webservice.aerospike.config.Parameters;
import com.webservices.demo.webservice.aerospike.model.Employee;
import com.webservices.demo.webservice.aerospike.service.EmployeeService;



@RestController
@RequestMapping("/rest/employees")
public class EmployeeResource{
	
	@Autowired
	private EmployeeService service ; 
	
	@GetMapping("/employee/{id}")
	public Employee retrieveOne(@PathVariable Integer id) {
		Employee employee = new Employee() ; 
		Key key =new Key(Parameters.spacename,Parameters.set,id);
		Record record =service.readRecord(key);
		if(record != null ) {
			employee.setId((Integer.parseInt(record.getValue("id").toString())));
			employee.setName((String)record.getValue("name"));
			employee.setSalary(Long.parseLong(record.getValue("salary").toString()));
		}
		return employee;
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		Key key =new Key(Parameters.spacename,Parameters.set,employee.getId());
		Bin nameBin =new Bin("name",employee.getName());
		Bin salaryBin =new Bin("salary",employee.getSalary());
		service.writeRecords(key, nameBin,salaryBin);
		return employee;
	}
	
	
	

}
