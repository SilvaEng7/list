package com.silvastack.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvastack.list.dto.GameListDto;
import com.silvastack.list.dto.GameMinDto;
import com.silvastack.list.services.GameListService;
import com.silvastack.list.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	
	@GetMapping
	public List<GameListDto> findAll(){
		List<GameListDto> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDto> findByList(@PathVariable Long listId){
		List<GameMinDto> result = gameService.findByList(listId);
		return result;
	}
}
