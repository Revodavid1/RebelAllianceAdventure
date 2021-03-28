package com.model;

import java.util.HashMap;

public class TargetSummary {

	/**
     * Total number of commands
     */
	private Integer totalCommands;
	
	/**
     * Total quantity
     */
	private Integer totalQuantity;
	
	/**
     * Average rate per target
     */
	private HashMap<String, Double> averageRatePerTarget;
	
	public TargetSummary() {
		super();
	}

	public TargetSummary(Integer totalCommands, Integer totalQuantity,
			HashMap<String, Double> averageRatePerTarget) {
		super();
		this.totalCommands = totalCommands;
		this.totalQuantity = totalQuantity;
		this.averageRatePerTarget = averageRatePerTarget;
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

	public HashMap<String, Double> getAverageRatePerTarget() {
		return averageRatePerTarget;
	}

	public void setAverageRatePerTarget(HashMap<String, Double> averageRatePerTarget) {
		this.averageRatePerTarget = averageRatePerTarget;
	}
	
}
