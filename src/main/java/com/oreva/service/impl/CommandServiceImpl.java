package com.oreva.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Command;
import com.repository.CommandRepository;
import com.service.CommandService;

@Service
@Transactional
public class CommandServiceImpl implements CommandService{

	@Autowired
	private CommandRepository commandRepository;
	
	@Override
	public List<Command> getCommands() {
		return commandRepository.findAll();
	}

	@Override
	public void add(Command command) {
		command.setRead("false");
		commandRepository.save(command);
	}

}
