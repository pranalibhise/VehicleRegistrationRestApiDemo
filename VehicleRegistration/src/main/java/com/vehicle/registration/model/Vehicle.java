package com.vehicle.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	private int vId;
	private String vName;
	private String vType;
	private String vModel;
	private String vMake;
	
	
	
	public Vehicle() {
		super();
	}
	public Vehicle(int vId, String vName, String vType, String vModel, String vMake) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vType = vType;
		this.vModel = vModel;
		this.vMake = vMake;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public String getvModel() {
		return vModel;
	}
	public void setvModel(String vModel) {
		this.vModel = vModel;
	}
	public String getvMake() {
		return vMake;
	}
	public void setvMake(String vMake) {
		this.vMake = vMake;
	}
	
	

	
}
