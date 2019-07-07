package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

public class AddressDeltaMaker implements BatchPreparedStatementSetter{
	
	List<AddressRequest> addReqL = null;

	public AddressDeltaMaker(List<AddressRequest> addReqL) {
		super();
		this.addReqL = addReqL;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		AddressRequest ar = addReqL.get(i);
		ps.setLong(1, ar.getId());
		ps.setString(2, ar.getStreet());
		for(Address ad : ar.getAdd()) {
			ps.setString(3, ad.getCity());
			ps.setString(4, ad.getState());
		}
		
	}

	@Override
	public int getBatchSize() {
		return addReqL.size();
	}

}
