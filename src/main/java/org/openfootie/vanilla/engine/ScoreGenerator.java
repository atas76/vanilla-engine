package org.openfootie.vanilla.engine;

import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.domain.MatchSample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ScoreGenerator {

    private List<MatchSample> seedSamples;
    private double xScoreHome;
    private double xScoreAway;

    public ScoreGenerator(List<MatchSample> seedSamples) {
        this.seedSamples = seedSamples;
    }

    public double getExpScoreHome() {
        return xScoreHome;
    }

    public double getExpScoreAway() {
        return xScoreAway;
    }

    private double calculateSampleAverage(Stream<Integer> stream) {
        return stream.reduce(0, Integer::sum) / (double) this.seedSamples.size();
    }

    private Random rnd = new Random();

    public void generate(Match match) {

        double homeRatingSampleAverage = calculateSampleAverage(this.seedSamples.stream().map(MatchSample::getHomeTeamRating));
        double awayRatingSampleAverage = calculateSampleAverage(this.seedSamples.stream().map(MatchSample::getAwayTeamRating));

        double homeScoreSampleAverage = calculateSampleAverage(this.seedSamples.stream().map(MatchSample::getHomeTeamScore));
        double awayScoreSampleAverage = calculateSampleAverage(this.seedSamples.stream().map(MatchSample::getAwayTeamScore));

        double homeRelativeEloFactor = match.getHomeTeam().getEloRanking() / homeRatingSampleAverage;
        double awayRelativeEloFactor = match.getAwayTeam().getEloRanking() / awayRatingSampleAverage;

        this.xScoreHome = homeRelativeEloFactor * homeScoreSampleAverage;
        this.xScoreAway = awayRelativeEloFactor * awayScoreSampleAverage;

        BigDecimal xScoreHomeBD = new BigDecimal(xScoreHome);
        BigDecimal xScoreAwayBD = new BigDecimal(xScoreAway);

        int homeScore = xScoreHomeBD.intValue();
        int awayScore = xScoreAwayBD.intValue();

        BigDecimal dScoreHome = xScoreHomeBD.subtract(new BigDecimal(homeScore));
        BigDecimal dScoreAway = xScoreAwayBD.subtract(new BigDecimal(awayScore));

        double homeScoreDecider = rnd.nextDouble();
        double awayScoreDecider = rnd.nextDouble();

        if (homeScoreDecider < dScoreHome.doubleValue()) {
            ++homeScore;
        }
        if (awayScoreDecider < dScoreAway.doubleValue()) {
            ++awayScore;
        }

        match.setFinalScore(homeScore, awayScore);
    }
}
