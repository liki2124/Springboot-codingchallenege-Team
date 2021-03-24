package com.mindtree.Game.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player 
{
	@Id
	@Column(name="pid")
	private int pid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="tname")
	private String tname;
	
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Column(name="age")
	private int age;
	
	@Column(name="role")
	private String role;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int pid, String pname, int age, String role) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.age = age;
		this.role = role;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRoleString(String role) {
		this.role = role;
	}
	
	
	
}
