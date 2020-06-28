package com.webservices.demo.webservice.aerospike.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;

@Service
public interface AerospikeOperation {
	
	public Record readRecord(Key key);
	
	public ArrayList<Record> readRecords(ArrayList<Key> keys);
	
	public boolean writeRecord(Key key,Bin bin) ;
	
	public  boolean writeRecords(Key key ,Bin...bins);
	
	public boolean deleteRecord(Key key);
}
