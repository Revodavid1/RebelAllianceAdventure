package com.scheduled;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.model.Command;
import com.model.ExecutiveSummary;
import com.model.TargetSummary;
import com.model.WeaponSummary;
import com.repository.CommandRepository;
import com.service.SummaryService;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	public static ExecutiveSummary executiveSummary;
	public static TargetSummary targetSummary;
	public static WeaponSummary weaponSummary;

	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private SummaryService summaryService;
	
	@Scheduled(fixedRate = 60000) //waits one 1 minute (60000 milliseconds) then analyzes summaries
	public void updateSummaries() {
		List<Command> commands = commandRepository.findByRead("false");
		
		executiveSummary = summaryService.getExecutiveSummary(commands);
		targetSummary = summaryService.getTargetSummary(commands);
		weaponSummary = summaryService.getWeaponSummary(commands);
		
		for(Command command : commands) {
			command.setRead("true"); //sets commands that have been analyzed to true
			commandRepository.save(command);
		}
		
		log.info("Command Analysis Updated");
	}
}
