package com.webservices.demo.webservice.aerospike.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.webservices.demo.webservice.aerospike.config.Parameters;

@Service
public class EmployeeService implements AerospikeOperation{
	
	@Autowired
	AerospikeClient client = Parameters.client ;
	
	@Override
	public Record readRecord(Key key) {return client.get(Parameters.policy, key);}

	@Override
	public ArrayList<Record> readRecords(ArrayList<Key> keys) {
		ArrayList<Record> records=new ArrayList<Record>();
			for(int j=0;j<keys.size();j++) {
				 records.add(client.get(Parameters.policy, keys.get(j)));
			}
		return records;
	}

	@Override
	public boolean writeRecord(Key key, Bin bin) {
		boolean success =true ; 
		try {
			
			client.put(Parameters.writePolicy, key, bin);
		}
		catch(AerospikeException ex) {
			success=false;
		}
		return success;
	}

	@Override
	public boolean writeRecords(Key key, Bin... bins) {
		boolean success =true ; 
		try {
			
			client.put(Parameters.writePolicy, key, bins);
		}
		catch(AerospikeException ex) {
			success=false;
		}
		return success;
	}

	@Override
	public boolean deleteRecord(Key key) {return client.delete(Parameters.writePolicy, key);}

	

}
