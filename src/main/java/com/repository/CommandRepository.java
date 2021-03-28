package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Command;

@Repository
public interface CommandRepository extends JpaRepository<Command, Integer> {
	List<Command> findByRead(String readValue);
}
