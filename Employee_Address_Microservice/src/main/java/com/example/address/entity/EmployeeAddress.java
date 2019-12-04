package com.example.address.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="address")
@JacksonXmlRootElement(localName="address")
public class EmployeeAddress {

	@Id
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@Column(name="empid")
	@JacksonXmlProperty
	private int empId;
	
	@Column
	@JacksonXmlProperty
	private String city;
	
	@Column
	@JacksonXmlProperty
	private String state;
	
	@Column(name="streetname")
	@JacksonXmlProperty
	private String streetName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	
}
