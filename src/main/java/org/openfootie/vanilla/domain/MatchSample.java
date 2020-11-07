package org.openfootie.vanilla.domain;

public class MatchSample {

    private int homeTeamPosition;
    private int awayTeamPosition;
    private int homeTeamScore;
    private int awayTeamScore;

    public MatchSample(int homeTeamPosition, int awayTeamPosition, int homeTeamScore, int awayTeamScore) {
        this.homeTeamPosition = homeTeamPosition;
        this.awayTeamPosition = awayTeamPosition;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamPosition() {
        return this.homeTeamPosition;
    }

    public int getAwayTeamPosition() {
        return this.awayTeamPosition;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }
}
