package com.mindtree.Game.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="team")
public class Team
{

	@Id
	@Column(name="tid")
	private int tid;
	
	@Column(name="tname")
	private String tname;
	
	@Column(name="location")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<Player> players;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int tid, String tname, String location, List<Player> players) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.location = location;
		this.players = players;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
	
	
	
}
