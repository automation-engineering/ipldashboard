package ipl.dashboard.ipldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ipl.dashboard.ipldashboard.model.Team;
import ipl.dashboard.ipldashboard.repository.MatchRepository;
import ipl.dashboard.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {
	
		
		
		TeamRepository teamRepo;
		MatchRepository matchRepo;
		
		public TeamController(TeamRepository teamR,MatchRepository matchR){
			this.teamRepo = teamR;
			this.matchRepo = matchR;
		}
		
		
		@GetMapping("/team/{teamName}")
		public Team getTeam(@PathVariable String teamName) {
			Team team = this.teamRepo.findByTeamName(teamName);
			team.setLatestMatches(this.matchRepo.findLatestMatchesByTeam(teamName,4));
			return team;
			
		}
		
		@GetMapping("/welcome")
		public String getHello() {
			return "Hello";
			
		}
}
