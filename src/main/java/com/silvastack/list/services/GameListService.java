package com.silvastack.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.silvastack.list.dto.GameListDto;
import com.silvastack.list.entities.GameList;
import com.silvastack.list.projection.GameMinProjection;
import com.silvastack.list.repositories.GameListRepository;
import com.silvastack.list.repositories.GameRepository;

@Component
public class GameListService {	
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDto> dto = result.stream().map(x -> new GameListDto(x)).toList();
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;	
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;	
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}
	
}
