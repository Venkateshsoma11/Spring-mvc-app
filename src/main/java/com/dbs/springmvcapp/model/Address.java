package com.dbs.springmvcapp.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String street;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	private String city;
    private String state;
    private String zip;

    @OneToOne(mappedBy = "address")
    @PrimaryKeyJoinColumn
    private Employee employee;
}