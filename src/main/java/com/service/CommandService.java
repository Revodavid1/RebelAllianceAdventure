package com.service;

import java.util.List;

import com.model.Command;

public interface CommandService {
	
	public List<Command> getCommands();
	public void add(Command command);
}
