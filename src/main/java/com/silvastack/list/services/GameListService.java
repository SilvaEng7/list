package com.silvastack.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.silvastack.list.dto.GameListDto;
import com.silvastack.list.entities.GameList;
import com.silvastack.list.repositories.GameListRepository;

@Component
public class GameListService {	
	
	@Autowired
	private GameListRepository gameListRepository;
	
	
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDto> dto = result.stream().map(x -> new GameListDto(x)).toList();
		return dto;
	}
}
