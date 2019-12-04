package com.example.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.address.entity.AddressClass;
import com.example.address.entity.EmployeeAddress;
import com.example.address.exceptions.IdNotFound;
import com.example.address.service.IAddressService;

@RestController
public class AddressController {

	@Autowired
	IAddressService service;

	//@GetMapping(value="/employee/address/{empId}", consumes = "application/json", produces = "application/json")
	@GetMapping(value="/employee/address/{empId}", produces = {"application/xml", "application/json"})
	public ResponseEntity<EmployeeAddress> getEmployeeAddress(@PathVariable("empId") int empId) throws IdNotFound, Exception {
		ResponseEntity<EmployeeAddress> response = null;
		EmployeeAddress empAdd = null;
		try {
			empAdd = service.getAddressById(empId);
			if(empAdd == null) {
				throw new IdNotFound("Employee Id does not exist.");
			}else {
				response = new ResponseEntity<EmployeeAddress>(empAdd, HttpStatus.OK);
			}
		}catch (IdNotFound e) {
			throw new IdNotFound("Employee Id does not exist.");
		}catch (Exception e) {
			throw new Exception("Some other exception");
		}
		return response;
	}
	
	/*This method is just to test JaxB parser
	 * */
	@GetMapping(value="employee/address/xml/{id}", produces="application/xml")
	public ResponseEntity<AddressClass> getXMLAddress(@PathVariable("id") long id) throws IdNotFound{
		return new ResponseEntity<AddressClass>(service.getAddressXML(id), HttpStatus.OK);
	}
}
