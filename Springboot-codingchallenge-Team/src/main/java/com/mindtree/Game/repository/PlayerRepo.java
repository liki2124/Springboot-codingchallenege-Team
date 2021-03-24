package com.mindtree.Game.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Game.entity.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer>
{
	public Player findById(int pid);
}
