package com.example.address.service;

import com.example.address.entity.AddressClass;
import com.example.address.entity.EmployeeAddress;
import com.example.address.exceptions.IdNotFound;

public interface IAddressService {

	public EmployeeAddress getAddressById(int empId) throws IdNotFound;
	//Just to test JaxB parser
	public AddressClass getAddressXML(long id) throws IdNotFound;
}
