package org.openfootie.vanilla.domain;

public class MatchSample {

    private int homeTeamRating;
    private int awayTeamRating;
    private int homeTeamScore;
    private int awayTeamScore;

    public MatchSample(int homeTeamRating, int awayTeamRating, int homeTeamScore, int awayTeamScore) {
        this.homeTeamRating = homeTeamRating;
        this.awayTeamRating = awayTeamRating;
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
