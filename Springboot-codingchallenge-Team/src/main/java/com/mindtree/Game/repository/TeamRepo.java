package com.mindtree.Game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Game.entity.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer> 
{
	
}
