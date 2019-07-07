package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleConnection;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public AddressRequest getAddress(Long id) {
		String sql ="select c.street  from customers c, table (c.address) a";
		List<String> s = jdbcTemplate.queryForList(sql, String.class);
		System.out.println(s);
		return null;
	}

	@Override
	public void saveMultipleAddress(List<AddressRequest> addReq) throws SQLException {
		OracleConnection oracleConnection = null;
		//Need to unwrap the hikari Connection to Oracle Connection
		try (Connection springhikariConnection = jdbcTemplate.getDataSource().getConnection()) {
			   if (springhikariConnection.isWrapperFor(OracleConnection.class)) {
			      oracleConnection = springhikariConnection.unwrap(OracleConnection.class);
			   }
		}catch (Exception e) {
			e.printStackTrace();
		}
		Connection conn = oracleConnection;
		String sql="INSERT INTO customers VALUES (?, ?, ?)";
		int result[] = jdbcTemplate.batchUpdate(sql, new DelataMakerBatch(addReq, conn));
		//below sql for inserting single String of ENUM type accordingly the DeltaMakerBatch prepared Statement will change
		//String sql = "INSERT INTO customers VALUES (?, ?, ?::Address_Tab)";
		//Below is for AddressDeltaMaker but it will store last record of Address as in while loop older value will be overwrite
		//String sql1="INSERT INTO customers VALUES (?,?, address_tab(address_t(?, ?)))";
		for(int x : result)
			System.out.println("Number of records inserted -> "+x);
	}

}
