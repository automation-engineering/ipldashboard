package ipl.dashboard.ipldashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import ipl.dashboard.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        final Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        String tossWinner = matchInput.getToss_winner();
        String tossDecision = matchInput.getToss_decision();
        if ((tossWinner == matchInput.getTeam1() && tossDecision == "bat")
                || (tossWinner == matchInput.getTeam2() && tossDecision == "field")) {
            match.setTeam1(matchInput.getTeam1());
            match.setTeam2(matchInput.getTeam2());
        } else {
            match.setTeam1(matchInput.getTeam2());
            match.setTeam2(matchInput.getTeam1());
        }
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setMatchWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        return match;
    }

}