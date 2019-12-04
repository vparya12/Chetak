package com.example.address.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This class is only to test JAXB xml parser
 * */
@Entity
@Table(name="xml")
@XmlRootElement
public class AddressClass {

	@Id
	private Long id;
	@Column
	private String street;
	@Column
	private String city;
	
	@Override
	public String toString() {
		return "AddressClass [id=" + id + ", street=" + street + ", city=" + city + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
