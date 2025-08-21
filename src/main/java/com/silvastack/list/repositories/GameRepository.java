package com.silvastack.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silvastack.list.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	

}
