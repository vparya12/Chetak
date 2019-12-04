package com.example.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address.dao.AddressDao;
import com.example.address.dao.AddressXMLTest;
import com.example.address.entity.AddressClass;
import com.example.address.entity.EmployeeAddress;
import com.example.address.exceptions.IdNotFound;

@Service
public class AddressService implements IAddressService {
	
	@Autowired
	AddressDao repo;
	
	@Autowired
	AddressXMLTest xml;
	
	public EmployeeAddress getAddressById(int empId) throws IdNotFound {
		EmployeeAddress empAdd = null;
		if(empId > 0) {
			empAdd = repo.getAddressByEmpId(empId);
		}
		return empAdd;
	}

	@Override
	public AddressClass getAddressXML(long id) throws IdNotFound {
		AddressClass xmlData = xml.getAddressById(id);
		System.out.println(xmlData);
		return xmlData;
	}
}
