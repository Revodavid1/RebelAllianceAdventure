package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.ExecutiveSummary;
import com.model.TargetSummary;
import com.model.WeaponSummary;
import com.scheduled.ScheduledTasks;

@RestController
@RequestMapping("/api/summary/")
public class SummaryController {
	/**
     * GET end point for executive summary
     */
	@GetMapping("/executive")
	public ResponseEntity<?> getExecutiveSummary(){
		return new ResponseEntity<ExecutiveSummary>(ScheduledTasks.executiveSummary, HttpStatus.OK);
	}
	
	/**
     * GET end point for target summary
     */
	@GetMapping("/target")
	public ResponseEntity<?> getTargetSummary(){
		return new ResponseEntity<TargetSummary>(ScheduledTasks.targetSummary, HttpStatus.OK);
	}
	
	/**
     * GET end point for weapon summary
     */
	@GetMapping("/weapon")
	public ResponseEntity<?> getWeaponSummary(){
		return new ResponseEntity<WeaponSummary>(ScheduledTasks.weaponSummary, HttpStatus.OK);
	}
}
