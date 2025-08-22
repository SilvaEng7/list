package com.silvastack.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.silvastack.list.dto.GameDto;
import com.silvastack.list.dto.GameMinDto;
import com.silvastack.list.entities.Game;
import com.silvastack.list.projection.GameMinProjection;
import com.silvastack.list.repositories.GameRepository;

@Component
public class GameService {	
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDto dto = new GameDto(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList( Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
	}
}
