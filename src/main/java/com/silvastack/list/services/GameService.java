package com.silvastack.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.silvastack.list.dto.GameMinDto;
import com.silvastack.list.entities.Game;
import com.silvastack.list.repositories.GameRepository;

@Component
public class GameService {	
	
	@Autowired
	private GameRepository gameRepository;
	public List<GameMinDto> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
	}
}
