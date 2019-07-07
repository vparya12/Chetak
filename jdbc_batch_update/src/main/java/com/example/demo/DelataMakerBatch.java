package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@SuppressWarnings("deprecation")
public class DelataMakerBatch implements BatchPreparedStatementSetter {
	
	//The Object name which has all the variables
	final String objectTypeName = "address_t";
	//the object/Data type(table) 
	final String objectTypeTableName = "address_tab";
	List<AddressRequest> addReqL = null;
	Connection conn;
	StructDescriptor structDescriptor = null;
	ArrayDescriptor arrayDescriptor = null;

	public DelataMakerBatch(List<AddressRequest> arl, Connection conn) throws SQLException {
		this.addReqL= arl;
		this.conn = conn;
		// Create a STRUCT description of object Type Name
		structDescriptor = StructDescriptor.createDescriptor(objectTypeName.toUpperCase(), conn);
		// Create a ARRAY description of object Type Table Name
		arrayDescriptor = ArrayDescriptor.createDescriptor(objectTypeTableName.toUpperCase(), conn);
	}
	
	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		AddressRequest ar = addReqL.get(i);
		STRUCT structArr[] = new STRUCT[ar.getAdd().size()];
		int structIndex = 0;
		//Creating array of STRUCT of address
		Object addObject[] = new Object[2];//numbers attributes in Address class
		for(Address a : ar.getAdd()) {
			addObject[0] = a.getCity();
			addObject[1] = a.getState();
			//Create STRUCT of above address Object and store in array
			STRUCT addressStruct = new STRUCT(structDescriptor, conn, addObject); 
			structArr[structIndex] = addressStruct;
			structIndex++;
		}
		//Create an ARRAY of all the above create STRUCT array so that you can set as preparedStatement
		ARRAY addTable =  new ARRAY(arrayDescriptor, conn, structArr);
		
		ps.setLong(1, ar.getId());
		ps.setString(2, ar.getStreet());
		ps.setArray(3, addTable);
			
	}

	@Override
	public int getBatchSize() {
		return addReqL.size();
	}

}
