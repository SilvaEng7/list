package com.silvastack.list.dto;

import com.silvastack.list.entities.GameList;

public class GameListDto {
	
	private Long id;
	private String name;
	
	public GameListDto(GameList entity) {
		name = entity.getName();
		id = entity.getId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
