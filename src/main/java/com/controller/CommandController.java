package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Command;
import com.service.CommandService;

@RestController
@RequestMapping("/api/commands/")
public class CommandController {
	
	@Autowired
	private CommandService commandService;
	
	/**
     * GET end point for a collection of all commands sent in.
     */
	@GetMapping("/read")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Command>>(commandService.getCommands(), HttpStatus.OK);
	}
	
	/**
     * POST end point to add a command.
     */
	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody Command command){
		commandService.add(command);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
