package ipl.dashboard.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import ipl.dashboard.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
		Team findByTeamName(String teamName);
		
}
