package com.webservices.demo.webservice.aerospike.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/connect")
public class ConnectionResource {
	
	 	@Autowired
	    public AerospikeConfiguration config ;
	 	
	    @GetMapping
	    public boolean connected(){
	        return config.aerospikeClient().isConnected();

	    }

	   
}
