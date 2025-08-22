package com.silvastack.list.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.silvastack.list.entities.GameList;


public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	
}
