package org.openfootie.vanilla.domain;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private final List<Team> teams;
    private List<Team> remainingTeams;
    private List<Round> rounds = new ArrayList<>();

    public Tournament(List<Team> teams) {
        this.teams = teams;
        this.remainingTeams = teams;
    }

    public int getParticipantsNum() {
        return teams.size();
    }

    public int getRemainingTeamsNum() {
        return this.remainingTeams.size();
    }

    public void play() {
        while (this.remainingTeams.size() > 2) {
            Round round = setupNextRound();
            round.draw();
            // TODO implement next
            this.remainingTeams = round.play();
            round.display();
        }
        // playFinal();
    }

    // TODO refactor the following methods (inline or reduce visibility after implementation is complete)
    // Currently keeping these around to satisfy tests
    public Round setupNextRound() {
        Round round = new Round(this.remainingTeams);
        this.rounds.add(round);
        return round;
    }

    public void setRemainingTeams(List<Team> teams) {
        this.remainingTeams = teams;
    }
}
