package com.silvastack.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvastack.list.dto.GameMinDto;

import com.silvastack.list.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;	
	@GetMapping
	public List<GameMinDto> findAll(){
		List<GameMinDto> result = gameService.findAll();
		return result;
	}
}
