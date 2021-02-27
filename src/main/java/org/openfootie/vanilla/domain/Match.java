package org.openfootie.vanilla.domain;

import org.openfootie.vanilla.scoresim.ScoreGenerator;

import static org.openfootie.vanilla.domain.MatchStatus.*;

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int homeScore = 0;
    private int awayScore = 0;
    private MatchStatus status = FIXTURE;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam =  homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        String score = status == FIXTURE ? "" : " " + homeScore + " - " + awayScore;
        return homeTeam.getName() + " - " + awayTeam.getName() + score;
    }

    public void setFinalScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.status = COMPLETED;
    }

    public int getHomeScore() {
        return this.homeScore;
    }

    public int getAwayScore() {
        return this.awayScore;
    }

    public MatchStatus getStatus() {
        return this.status;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void play(ScoreGenerator scoreGenerator) {
        scoreGenerator.generate(this);
    }
}
