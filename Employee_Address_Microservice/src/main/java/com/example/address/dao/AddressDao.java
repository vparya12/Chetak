package com.example.address.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.address.entity.EmployeeAddress;

@Repository
public interface AddressDao extends JpaRepository<EmployeeAddress, Long>{
	
	public EmployeeAddress getAddressByEmpId(int empId);

}
