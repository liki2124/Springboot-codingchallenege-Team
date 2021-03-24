package com.mindtree.Game.controller;



	import java.util.LinkedHashMap;
	import java.util.List;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;


	import com.mindtree.Game.entity.Player;
	import com.mindtree.Game.entity.Team;
	import com.mindtree.Game.exception.IdNotFoundException;
	import com.mindtree.Game.service.TeamService;



	@RequestMapping("/Game")
	@RestController
	public class TeamController
	{

		@Autowired
		private TeamService gameservice;
		
		//create team
		@PostMapping("/addTeam")
		public ResponseEntity<?> createTeam(@RequestBody Team team )
		{
				Map<String,Object> map= new LinkedHashMap<>();
				try
				{
					Team t=TeamService.createTeam(team);
					map.put("Team added", t);
					map.put("message", "ok");
					return new ResponseEntity<>(map,HttpStatus.OK);
				}
				catch(Exception e)
				{
					System.out.println(e.getLocalizedMessage());
				}

				
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
		}
		
		//create player
		@PostMapping("/addPlayer/{tid}")
		public ResponseEntity<?> createMind(@RequestBody Player player , @PathVariable(name="tid") int tid)
		{
			Map<String,Object> map= new LinkedHashMap<>();
			try 
			{
				Player p=gameservice.createMind(player,tid);
				map.put("Player added", p);
				map.put("message", "ok");
				return new ResponseEntity<>(map,HttpStatus.OK);
			}
			catch(Exception e)
			{
				System.out.println(e.getLocalizedMessage());
			}

			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		
		//getalldetails
		@GetMapping("/retrieveAllByTeamName/{tname}")
		public ResponseEntity<?> getAllDetails(@PathVariable(name="tname") String tname) throws IdNotFoundException
		{
		
			Map<String,Object> map= new LinkedHashMap<>();
			
			try 
			{
				
				List<Player> m=gameservice.getAllDetails(tname);
				map.put("All details", m);
				map.put("message", "ok");
				return new ResponseEntity<>(map,HttpStatus.OK);
			}
			catch(IdNotFoundException e)
			{
				System.out.println(e.getLocalizedMessage());
				map.put("Message","Trackname not found!");
				
			}

			
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		@PutMapping("/updateTeamLoc/{tid}")
		public ResponseEntity<?> updateTeamLoc(@RequestBody String location,@PathVariable(name="tid") int tid) throws IdNotFoundException
		{
			Map<String,Object> map= new LinkedHashMap<>();
			try {
				Team t=gameservice.updateTeamLoc(location,tid);
				map.put("updated location", t);
				map.put("message", "updated ");
				return new ResponseEntity<>(map,HttpStatus.OK);
			}
			catch(IdNotFoundException e)
			{
				System.out.println(e.getLocalizedMessage());
				map.put("Message","ID not found!");
			}
			
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}
		
		@DeleteMapping("/deletePlayerByTeamID/{pid}")
		public ResponseEntity<?> deletePlayerByPlayrerID(@PathVariable(name="pid") int pid)
		{
			
			Map<String,Object> map= new LinkedHashMap<>();
			try {
				Player p=gameservice.deletePlayerByPlayerID(pid);
				
				map.put("Message","Deleted player");
				return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
			}
			catch(Exception e)
			{
				System.out.println(e.getLocalizedMessage());
			}

			
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	
	
	
