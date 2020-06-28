package com.webservices.demo.webservice.aerospike.config;


import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;

public class Parameters {

		public static AerospikeClient client =AerospikeConfiguration.aerospikeClient();
		public static WritePolicy writePolicy =new WritePolicy();
		public static Policy policy =new WritePolicy() ;
		public static ScanPolicy scanPolicy =new ScanPolicy() ;
		public static String spacename="test";
		public static  String set ="myTest";
		
}
