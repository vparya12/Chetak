package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcBatchUpdateApplication implements CommandLineRunner{

	@Autowired
	AddressDao addDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcBatchUpdateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<AddressRequest> arl = new ArrayList<>();
		Address a1 = new Address();
		Address a2 = new Address();
		Address a3 = new Address();
		a1.setCity("Patna");
		a1.setState("Bihar");
		
		a2.setCity("Pune");
		a2.setState("Maharastra");
		
		a3.setCity("Jaipur");
		a3.setState("Rajsthan");
		
		List<Address> al = new ArrayList<>();
		al.add(a1);
		al.add(a2);
		al.add(a3);
		
		AddressRequest ar1 = new AddressRequest();
		AddressRequest ar2 = new AddressRequest();
		AddressRequest ar3 = new AddressRequest();
		ar1.setId(10001l);
		ar1.setStreet("Love Road 1");
		ar1.setAdd(al);
		
		ar2.setId(10002l);
		ar2.setStreet("Love Road 2");
		ar2.setAdd(al);
		
		ar3.setId(10003l);
		ar3.setStreet("Love Road 3");
		ar3.setAdd(al);
		
		arl.add(ar1);
		arl.add(ar2);
		arl.add(ar3);
		addDao.saveMultipleAddress(arl);
	}

}
