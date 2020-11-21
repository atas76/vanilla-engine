package org.openfootie.vanilla.domain;

public class MatchSample {

    private int homeTeamRating;
    private int awayTeamRating;
    private int homeTeamScore;
    private int awayTeamScore;

    public MatchSample(int homeTeamPosition, int awayTeamPosition, int homeTeamScore, int awayTeamScore) {
        this.homeTeamRating = homeTeamPosition;
        this.awayTeamRating = awayTeamPosition;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamRating() {
        return this.homeTeamRating;
    }

    public int getAwayTeamRating() {
        return this.awayTeamRating;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }
}
