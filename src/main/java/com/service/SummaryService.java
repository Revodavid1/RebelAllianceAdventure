package com.service;

import java.util.List;

import com.model.Command;
import com.model.ExecutiveSummary;
import com.model.TargetSummary;
import com.model.WeaponSummary;

public interface SummaryService {
	public ExecutiveSummary getExecutiveSummary(List<Command> commands);
	public TargetSummary getTargetSummary(List<Command> commands);
	public WeaponSummary getWeaponSummary(List<Command> commands);
}
