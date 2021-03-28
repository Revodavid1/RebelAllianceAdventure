package com.model;


public class ExecutiveSummary {
	/**
     * Total number of commands
     */
	private Integer totalCommands;
	
	/**
     * Total quantity
     */
	private Integer totalQuantity;
	
	/**
     * Total rate
     */
	private Integer totalRate;
	
	/**
     * Total number of combined attacks
     */
	private Integer totalCombinedAttacks;
	
	public ExecutiveSummary() {
		super();
	}

	public ExecutiveSummary(Integer totalCommands, Integer totalQuantity, Integer totalRate,
			Integer totalCombinedAttacks) {
		super();
		this.totalCommands = totalCommands;
		this.totalQuantity = totalQuantity;
		this.totalRate = totalRate;
		this.totalCombinedAttacks = totalCombinedAttacks;
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

	public Integer getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(Integer totalRate) {
		this.totalRate = totalRate;
	}

	public Integer getTotalCombinedAttacks() {
		return totalCombinedAttacks;
	}

	public void setTotalCombinedAttacks(Integer totalCombinedAttacks) {
		this.totalCombinedAttacks = totalCombinedAttacks;
	}
	
	
}
