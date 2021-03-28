package com.oreva.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.model.Command;
import com.model.ExecutiveSummary;
import com.model.TargetSummary;
import com.model.WeaponSummary;
import com.service.SummaryService;

@Service
public class SummaryServiceImpl implements SummaryService {
	
	@Override
	public ExecutiveSummary getExecutiveSummary(List<Command> commands) {
		ExecutiveSummary executiveSummary = new ExecutiveSummary();
		executiveSummary.setTotalCommands(commands.size());
		executiveSummary.setTotalQuantity(calculateTotalQuantity(commands));
		executiveSummary.setTotalRate(calculateTotalRate(commands));
		executiveSummary.setTotalCombinedAttacks(countCombinedAttacks(commands));
		return executiveSummary;
	}

	@Override
	public TargetSummary getTargetSummary(List<Command> commands) {
		TargetSummary targetSummary = new TargetSummary();
		targetSummary.setTotalCommands(commands.size());
		targetSummary.setTotalQuantity(calculateTotalQuantity(commands));
		targetSummary.setAverageRatePerTarget(calculateRatePerTarget(commands));
		return targetSummary;
	}

	@Override
	public WeaponSummary getWeaponSummary(List<Command> commands) {
		WeaponSummary weaponSummary = new WeaponSummary();
		weaponSummary.setTotalCommands(commands.size());
		weaponSummary.setTotalQuantity(calculateTotalQuantity(commands));
		weaponSummary.setAverageRatePerWeapon(calculateRatePerWeapon(commands));
		return weaponSummary;
	}
	
	/**
     * Calculates total quantity for all commands for the current analysis
     * @param commands - List of unread commands
     * @return - Total quantity
     */
	public int calculateTotalQuantity(List<Command> commands) {
		int sum = 0;
		for(Command command : commands) {
			sum += command.getQuantity();
		}
		return sum;
	}
	
	/**
     * Calculates total rate for all commands for the current analysis
     * @param commands - List of unread commands
     * @return - Total rate
     */
	public int calculateTotalRate(List<Command> commands) {
		int sum = 0;
		for(Command command : commands) {
			sum += command.getRate();
		}
		return sum;
	}
	
	/**
     * Counts all possible combined attacks
     * @param commands - List of unread commands
     * @return - count of combined attacks
     */
	public int countCombinedAttacks(List<Command> commands) {
		int combinableAttacks = 0;
		List<Command> copyCommand = new ArrayList<>();
        
		for(Command command : commands) {
			
			Predicate<Command> combinedAttacked = c -> c.getBattleship() == command.getBattleship() 
					&& c.getWeaponSystem() == command.getWeaponSystem() 
					&& c.getTarget() == command.getTarget();
			
			long searchIfChecked = copyCommand.stream().filter(combinedAttacked).count();
			
			if(searchIfChecked < 1) {
				long searchCombined = commands.stream().filter(combinedAttacked).count();
				
				if(searchCombined > 1) {
					combinableAttacks++;
					copyCommand.add(command);
				}
			}
		}
		
		return combinableAttacks;
	}
	
	/**
     * Calculates average rate per target
     * @param commands - List of unread commands
     * @return - Key value map of targets and average rates
     */
	public HashMap<String, Double> calculateRatePerTarget(List<Command> commands){
		HashMap<String, List<Integer>> targetRates = new HashMap<>();
		HashMap<String, Double> averageTargetRates = new HashMap<>();
		
		for(Command command : commands) {
			targetRates.put(command.getTarget(), new ArrayList<>());
		}
		
		for(Command command : commands) {
			targetRates.get(command.getTarget()).add(command.getRate());
		}
		
		for (Map.Entry<String,List<Integer>> targets : targetRates.entrySet()) {
			averageTargetRates.put(targets.getKey(), calculateRateAverages(targets.getValue()));
		}
           
		return averageTargetRates;
		
	}
	
	/**
     * Calculates average rate per weapon
     * @param commands - List of unread commands
     * @return - Key value map of weapon and average rates
     */
	public HashMap<String, Double> calculateRatePerWeapon(List<Command> commands){
		HashMap<String, List<Integer>> weaponRates = new HashMap<>();
		HashMap<String, Double> averageWeaponRates = new HashMap<>();
		
		for(Command command : commands) {
			weaponRates.put(command.getWeaponSystem(), new ArrayList<>());
		}
		
		for(Command command : commands) {
			weaponRates.get(command.getWeaponSystem()).add(command.getRate());
		}
		
		for (Map.Entry<String,List<Integer>> weapons : weaponRates.entrySet()) {
			averageWeaponRates.put(weapons.getKey(), calculateRateAverages(weapons.getValue()));
		}
           
		return averageWeaponRates;
	}
	
	/**
     * Calculates average rates from a list of rates
     * @param commands - List of rates
     * @return - Double value of average rate
     */
	public Double calculateRateAverages(List<Integer> rates) {
		int sum = 0;
		for(int rate : rates) {
			sum += rate;
		}
		return Double.valueOf(sum) / rates.size();
	}
	
	
}
