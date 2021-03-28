package com.model;

import java.util.HashMap;

public class WeaponSummary {
	/**
     * Total number of commands
     */
	private Integer totalCommands;
	
	/**
     * Total quantity
     */
	private Integer totalQuantity;
	
	/**
     * Average rate per weapon
     */
	private HashMap<String, Double> averageRatePerWeapon;
	
	public WeaponSummary() {
		super();
	}

	public WeaponSummary(Integer totalCommands, Integer totalQuantity, HashMap<String, Double> averageRatePerWeapon) {
		super();
		this.totalCommands = totalCommands;
		this.totalQuantity = totalQuantity;
		this.averageRatePerWeapon = averageRatePerWeapon;
	}

	public Integer getTotalCommands() {
		return totalCommands;
	}

	public void setTotalCommands(Integer totalCommands) {
		this.totalCommands = totalCommands;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public HashMap<String, Double> getAverageRatePerWeapon() {
		return averageRatePerWeapon;
	}

	public void setAverageRatePerWeapon(HashMap<String, Double> averageRatePerWeapon) {
		this.averageRatePerWeapon = averageRatePerWeapon;
	}
}
