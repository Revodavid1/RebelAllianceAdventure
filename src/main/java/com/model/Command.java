package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="commands")
public class Command {
	/**
     * System generated id for the command
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commandId;
	/**
     * Weapon System
     */
	@NonNull
	private String weaponSystem;
	/**
     * Battle Ship
     */
	@NonNull
	private String battleship;
	/**
     * Target
     */
	@NonNull
	private String target;
	/**
     * Quantity
     */
	@NonNull
	private Integer quantity;
	/**
     * Rate
     */
	@NonNull
	private Integer rate;
	/**
     * Read Flag
     */
	private String read;
	
	
	public Command() {
		super();
	}
	
	public Command(Integer commandId, String weaponSystem, String battleship, String target, Integer quantity,
			Integer rate, String read) {
		super();
		this.commandId = commandId;
		this.weaponSystem = weaponSystem;
		this.battleship = battleship;
		this.target = target;
		this.quantity = quantity;
		this.rate = rate;
		this.read = read;
	}


	public Integer getCommandId() {
		return commandId;
	}

	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}

	public String getWeaponSystem() {
		return weaponSystem;
	}

	public void setWeaponSystem(String weaponSystem) {
		this.weaponSystem = weaponSystem;
	}

	public String getBattleship() {
		return battleship;
	}

	public void setBattleship(String battleship) {
		this.battleship = battleship;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}
}
