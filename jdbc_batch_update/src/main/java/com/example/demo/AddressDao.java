package com.example.demo;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {

	public AddressRequest getAddress(Long id);
	
	public void saveMultipleAddress(List<AddressRequest> addReq) throws SQLException;
}
