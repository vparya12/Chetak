package com.example.address.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.address.entity.AddressClass;
/*This class is just to test JaxB parsers
 * */
@Repository
public interface AddressXMLTest extends JpaRepository<AddressClass, Long>{
	public AddressClass getAddressById(long id);
}
